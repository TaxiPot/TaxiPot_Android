package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;

import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentChattingBinding;
import com.example.taxipot_android.domain.entity.ChattingEntity;
import com.example.taxipot_android.presenter.ui.BaseActivity;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.ui.adapter.ChattingAdapter;
import com.example.taxipot_android.presenter.viewModel.ChattingViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.ChattingViewModelFactory;
import com.example.taxipot_android.util.ActivityFinish;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class ChattingFragment extends BaseActivity implements ActivityFinish {

    FragmentChattingBinding binding;
    @Inject
    ChattingViewModelFactory factory;
    ChattingViewModel viewModel;

    private Subject<Long> backButtonSubject = BehaviorSubject.createDefault(0L);
    private Disposable backButtonSubjectDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this,factory).get(ChattingViewModel.class);
        ChattingAdapter adapter = new ChattingAdapter(this, viewModel);
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_chatting);
        binding.setActivity(this);
        binding.setVm(viewModel);
        binding.setLifecycleOwner(this);
        binding.chatRecyclerview.setAdapter(adapter);
        binding.chatRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        viewModel.chattingList.observe(this, new Observer<List<ChattingEntity>>() {
            @Override
            public void onChanged(List<ChattingEntity> chattingEntities) {
                if(chattingEntities.size()==0) return;
                adapter.add(chattingEntities.get(chattingEntities.size()-1));
                adapter.notifyItemInserted(chattingEntities.size()-1);
                binding.chatRecyclerview.scrollToPosition(adapter.getItemCount()-1);
            }
        });
        viewModel.connect();
        viewModel.setFinisher(this);

        initDoubleBackButton();
    }

    private void initDoubleBackButton() {
        // Rx로 작성한 Double Back Button.
        backButtonSubjectDisposable = backButtonSubject.buffer(2, 1)
                .map(it -> new Pair<>(it.get(0), it.get(1)))
                .map(pair -> pair.second - pair.first < TimeUnit.SECONDS.toMillis(2))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(willFinish -> {
                    if(willFinish) finish();
                    else Toast.makeText(this, "뒤로가기 버튼을 다시 누르면 채팅방을 나갑니다.", Toast.LENGTH_SHORT).show();
                });
    }

    @Override
    public void onBackPressed() {
        backButtonSubject.onNext(System.currentTimeMillis());
    }

    @Override
    protected void showToast() {

    }

    @Override
    protected void onDestroy() {
        viewModel.disconnect(null);
        super.onDestroy();
    }
}

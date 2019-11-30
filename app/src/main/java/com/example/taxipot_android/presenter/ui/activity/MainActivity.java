package com.example.taxipot_android.presenter.ui.activity;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivityMainBinding;
import com.example.taxipot_android.di.application.BaseApplication;
import com.example.taxipot_android.presenter.ui.BaseActivity;
import com.example.taxipot_android.presenter.ui.fragment.ChattingFragment;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;
    Fragment fragment;

    private Subject<Long> backButtonSubject = BehaviorSubject.createDefault(0L);
    private Disposable backButtonSubjectDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
        initDoubleBackButton();

        fragment = getSupportFragmentManager().findFragmentById(R.id.main_fragment_space_fragment);

        if (fragment instanceof NavHostFragment) {
            Log.i("fragment", "instanceofNavHost");
            NavigationUI.setupWithNavController(binding.mainBottomnavigation, ((NavHostFragment) fragment).getNavController());
        }
    }

    private void initDoubleBackButton() {
        // Rx로 작성한 Double Back Button.
        backButtonSubjectDisposable = backButtonSubject.buffer(2, 1)
                .map(it -> new Pair<>(it.get(0), it.get(1)))
                .map(pair -> pair.second - pair.first < TimeUnit.SECONDS.toMillis(2))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(willFinish -> {
                    if(willFinish) finish();
                    else Toast.makeText(this, "뒤로가기 버튼을 한번 누르면 앱을 종료합니다.", Toast.LENGTH_SHORT).show();
                });
    }

    @Override
    public void onBackPressed() {
        backButtonSubject.onNext(System.currentTimeMillis());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(BaseApplication.getUser().getRoomId()!=null) {
            startActivity(new Intent(MainActivity.this, ChattingFragment.class));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        backButtonSubjectDisposable.dispose();
    }

    @Override
    protected void showToast() {

    }
}

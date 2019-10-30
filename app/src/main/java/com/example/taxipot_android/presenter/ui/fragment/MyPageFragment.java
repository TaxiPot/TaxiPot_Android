package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.data.api.UserApi;
import com.example.taxipot_android.databinding.FragmentMypageBinding;
import com.example.taxipot_android.di.application.BaseApplication;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.viewModel.MyPageViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.MyPageViewModelFactory;
import com.example.taxipot_android.util.CreateRetrofit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import static com.example.taxipot_android.di.application.BaseApplication.setUser;

public class MyPageFragment extends BaseFragment<FragmentMypageBinding> {

    MyPageViewModel viewModel;
    MyPageViewModelFactory factory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_mypage);
        View v = super.onCreateView(inflater, container, savedInstanceState);
        this.viewModel = ViewModelProviders.of(this, factory).get(MyPageViewModel.class);
        binding.setFragment(this);
        binding.setVm(viewModel);

        getUserData();
        return v;
    }

    private void getUserData() {
        User user = BaseApplication.getUser();
        CreateRetrofit.createRetrofit(UserApi.class)
                .requestSignIn(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<User>() {
                    @Override
                    public void onSuccess(User user) {
                        setUser(user);
                        setUserDataInUI();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getContext(), "서버 통신 오류 : " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void setUserDataInUI() {
        viewModel.isMan.setValue(BaseApplication.getUser().getIsMan());
        viewModel.trustPoint.setValue(BaseApplication.getUser().getTrustPoint());
        viewModel.age.setValue(BaseApplication.getUser().getAge());
    }
}

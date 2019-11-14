package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentMypageBinding;
import com.example.taxipot_android.di.application.BaseApplication;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.viewModel.MyPageViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.MyPageViewModelFactory;

import javax.inject.Inject;

public class MyPageFragment extends BaseFragment<FragmentMypageBinding> {

    MyPageViewModel viewModel;
    @Inject
    MyPageViewModelFactory factory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_mypage);
        View v = super.onCreateView(inflater, container, savedInstanceState);
        viewModel = ViewModelProviders.of(this, factory).get(MyPageViewModel.class);
        binding.setFragment(this);
        binding.setVm(viewModel);
        setUserDataInUI();
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel.refreshUserData(BaseApplication.getUser());
    }

    private void setUserDataInUI() {
        viewModel.isMan.setValue(BaseApplication.getUser().getIsMan());
        viewModel.trustPoint.setValue(BaseApplication.getUser().getTrustPoint());
        viewModel.age.setValue(BaseApplication.getUser().getAge());
    }
}

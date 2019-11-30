package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentChattingBinding;
import com.example.taxipot_android.presenter.ui.BaseActivity;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.viewModel.ChattingViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.ChattingViewModelFactory;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class ChattingFragment extends BaseActivity {

    FragmentChattingBinding binding;
    @Inject
    ChattingViewModelFactory factory;
    ChattingViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this,factory).get(ChattingViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_chatting);
        binding.setActivity(this);
        binding.setVm(viewModel);
        viewModel.connect();
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void showToast() {

    }

    @Override
    protected void onDestroy() {
        viewModel.destroy();
        super.onDestroy();
    }
}

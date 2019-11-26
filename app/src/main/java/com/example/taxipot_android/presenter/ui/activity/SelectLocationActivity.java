package com.example.taxipot_android.presenter.ui.activity;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivitySelectLocationBinding;
import com.example.taxipot_android.presenter.ui.BaseActivity;
import com.example.taxipot_android.presenter.viewModel.SelectLocationViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.SelectLocationViewModelFactory;

public class SelectLocationActivity extends BaseActivity {

    ActivitySelectLocationBinding binding;
    SelectLocationViewModel viewModel;
    SelectLocationViewModelFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, factory).get(SelectLocationViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_location);
        binding.setVm(viewModel);
    }

    @Override
    protected void showToast() {

    }
}

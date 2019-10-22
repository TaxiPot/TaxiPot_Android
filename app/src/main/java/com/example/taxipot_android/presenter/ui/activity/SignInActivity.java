package com.example.taxipot_android.presenter.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivitySignInBinding;
import com.example.taxipot_android.presenter.ui.BaseActivity;
import com.example.taxipot_android.presenter.viewModel.SignInViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.SignInViewModelFactory;

public class SignInActivity extends BaseActivity {

    ActivitySignInBinding binding;

    SignInViewModel viewModel;
    SignInViewModelFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, factory).get(SignInViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);
        binding.setActivity(this);
    }

    public void doSignUp(View v) {
        startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
    }

    public void doSignIn(View v) {
        startActivity(new Intent(SignInActivity.this, MainActivity.class));
        finish();
    }
}

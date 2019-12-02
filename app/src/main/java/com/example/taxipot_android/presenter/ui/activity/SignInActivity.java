package com.example.taxipot_android.presenter.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivitySignInBinding;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.presenter.ui.BaseActivity;
import com.example.taxipot_android.presenter.viewModel.SignInViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.SignInViewModelFactory;

import javax.inject.Inject;

public class SignInActivity extends BaseActivity {

    ActivitySignInBinding binding;

    SignInViewModel viewModel;
    @Inject
    SignInViewModelFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, factory).get(SignInViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);
        binding.setLifecycleOwner(this);
        binding.setActivity(this);
        binding.setVm(viewModel);

        viewModel.user.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                setUser(user);
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void doSignUp(View v) {
        Log.e(this.getClass().getSimpleName(), "TouchEvent");
        Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    protected void showToast() {
        viewModel.getToast().observe(this, toastObserver);
    }
}

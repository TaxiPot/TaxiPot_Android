package com.example.taxipot_android.presenter.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivitySignInBinding;
import com.example.taxipot_android.presenter.ui.BaseActivity;

public class SignInActivity extends BaseActivity {

    ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);
        binding.setActivity(this);
    }

    public void doSignUp(View v) {
        startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
    }

    public void doSignIn(View v) {
        startActivity(new Intent(SignInActivity.this, MainActivity.class));
    }
}

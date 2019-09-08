package com.example.taxipot_android.presenter.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivitySignInBinding;
import com.example.taxipot_android.presenter.ui.BaseActivity;

import javax.inject.Inject;

public class SignInActivity extends BaseActivity {

    ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);
        binding.setActivity(this);
    }

    public void doSignUp(View v) {
        Log.i("doSignUp","why..?");
        startActivity(new Intent(this, SignUpActivity.class));
    }
}

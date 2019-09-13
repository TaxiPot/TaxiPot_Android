package com.example.taxipot_android.presenter.ui.activity;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivitySignUpBinding;
import com.example.taxipot_android.presenter.ui.BaseActivity;
import com.example.taxipot_android.presenter.viewModel.SignUpViewModel;

import javax.inject.Inject;

public class SignUpActivity extends BaseActivity {

    ActivitySignUpBinding binding;
    @Inject
    ViewModelProvider.Factory factory;
    SignUpViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up);

        viewModel = ViewModelProviders.of(this,factory).get(SignUpViewModel.class);
        binding.setVm(viewModel);
        binding.setActivity(this);

        viewModel.isMan.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean) {
                    binding.signup2GenderIsManRb.setTextColor(Color.WHITE);
                    binding.signup2GenderIsWomanRb.setTextColor(ContextCompat.getColor(SignUpActivity.this,R.color.barColor));
                } else {
                    binding.signup2GenderIsManRb.setTextColor(ContextCompat.getColor(SignUpActivity.this,R.color.barColor));
                    binding.signup2GenderIsWomanRb.setTextColor(Color.WHITE);
                }
            }
        });
    }

    public void requestSignUpActivity(View v){
        Toast.makeText(this,"회원가입 완료",Toast.LENGTH_SHORT).show();
    }
}

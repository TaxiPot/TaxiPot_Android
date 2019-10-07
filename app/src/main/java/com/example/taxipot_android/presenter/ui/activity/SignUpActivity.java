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
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivitySignUpBinding;
import com.example.taxipot_android.presenter.ui.BaseActivity;
import com.example.taxipot_android.presenter.viewModel.SignUpViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.SignUpViewModelFactory;

import javax.inject.Inject;

public class SignUpActivity extends BaseActivity {

    ActivitySignUpBinding binding;
    @Inject
    SignUpViewModelFactory factory;
    SignUpViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);

        viewModel = ViewModelProviders.of(this, factory).get(SignUpViewModel.class);
        binding.setVm(viewModel);
        binding.setActivity(this);
        liveDataObserve();
    }

    private void liveDataObserve() {
        viewModel.isMan.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean) {
                    changeTextColorRadioButton(binding.signup2GenderIsManRb, binding.signup2GenderIsWomanRb);
                } else {
                    changeTextColorRadioButton(binding.signup2GenderIsWomanRb, binding.signup2GenderIsManRb);
                }
            }
        });
        viewModel.ageLimit.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(Integer.parseInt(s) > 99) {
                    viewModel.ageLimit.postValue("99");
                } else if(Integer.parseInt(s) < 0){
                    viewModel.ageLimit.postValue("00");
                }
            }
        });
    }

    public void requestSignUpActivity(View v) {
        Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void changeTextColorRadioButton(RadioButton selView, RadioButton view) {
        selView.setTextColor(Color.WHITE);
        view.setTextColor(ContextCompat.getColor(SignUpActivity.this,R.color.barColor));
    }
}

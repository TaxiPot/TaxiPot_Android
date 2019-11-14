package com.example.taxipot_android.presenter.ui.activity;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;

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
        viewModel = ViewModelProviders.of(this, factory).get(SignUpViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);
        binding.setVm(viewModel);
        binding.setActivity(this);
        liveDataObserve();
    }

    private void changeTextColorRadioButton(RadioButton selView, RadioButton view) {
        selView.setTextColor(Color.WHITE);
        view.setTextColor(ContextCompat.getColor(SignUpActivity.this, R.color.barColor));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void liveDataObserve() {
        viewModel.isMan.observe(this, aBoolean -> {
            if (aBoolean) {
                changeTextColorRadioButton(binding.signup2GenderIsManRb, binding.signup2GenderIsWomanRb);
            } else {
                changeTextColorRadioButton(binding.signup2GenderIsWomanRb, binding.signup2GenderIsManRb);
            }
        });

        viewModel.ageLimit.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s.length() == 0) {
                    viewModel.ageLimit.postValue("00");
                } else {
                    if (Integer.parseInt(s) > 99) {
                        viewModel.ageLimit.postValue("99");
                        binding.signupAgeEt.setText("99");
                    } else if (Integer.parseInt(s) < 0) {
                        viewModel.ageLimit.postValue("00");
                        binding.signupAgeEt.setText("00");
                    }
                }
            }
        });
    }

    @Override
    protected void showToast() {
        viewModel.getToast().observe(this, toastObserver);
    }
}

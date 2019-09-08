package com.example.taxipot_android.presenter.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivitySignUp2Binding;
import com.example.taxipot_android.presenter.ui.BaseActivity;
import com.example.taxipot_android.presenter.viewModel.SignUp2ViewModel;

import javax.inject.Inject;

public class SignUp2Activity extends BaseActivity {

    ActivitySignUp2Binding binding;
    @Inject
    ViewModelProvider.Factory factory;
    SignUp2ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up2);

        viewModel = ViewModelProviders.of(this,factory).get(SignUp2ViewModel.class);
        binding.setVm(viewModel);
        binding.setActivity(this);

        viewModel.canMan.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean) {
                    binding.signup2GenderIsManRb.setTextColor(Color.WHITE);
                } else {
                    binding.signup2GenderIsManRb.setTextColor(ContextCompat.getColor(SignUp2Activity.this,R.color.barColor));
                }
            }
        });

        viewModel.canWoman.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean) {
                    binding.signup2GenderIsWomanRb.setTextColor(Color.WHITE);
                } else {
                    binding.signup2GenderIsWomanRb.setTextColor(ContextCompat.getColor(SignUp2Activity.this,R.color.barColor));
                }
            }
        });
    }
}

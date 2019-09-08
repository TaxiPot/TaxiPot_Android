package com.example.taxipot_android.presenter.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivitySignUpBinding;
import com.example.taxipot_android.presenter.ui.BaseActivity;

public class SignUpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySignUpBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up);
        binding.setActivity(this);
    }

    public void requestNextSignUpActivity(View v){
        startActivity(new Intent(SignUpActivity.this,SignUp2Activity.class));
    }
}

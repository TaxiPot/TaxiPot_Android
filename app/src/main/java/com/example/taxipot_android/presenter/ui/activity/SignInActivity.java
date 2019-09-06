package com.example.taxipot_android.presenter.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.example.taxipot_android.R;
import com.example.taxipot_android.presenter.ui.BaseActivity;

import javax.inject.Inject;

public class SignInActivity extends BaseActivity {
    @Inject
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Log.i("Dagger 2", string);
    }
}

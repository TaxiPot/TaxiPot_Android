package com.example.taxipot_android.presenter.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.taxipot_android.R;
import com.example.taxipot_android.presenter.ui.BaseActivity;

import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);
    }
}

package com.example.taxipot_android.presenter.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivityMainBinding;
import com.example.taxipot_android.presenter.ui.BaseActivity;
import com.example.taxipot_android.util.BottomNavigationHandler;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setActivity(this);
        binding.setHandler(new BottomNavigationHandler(getSupportFragmentManager()));
    }



}

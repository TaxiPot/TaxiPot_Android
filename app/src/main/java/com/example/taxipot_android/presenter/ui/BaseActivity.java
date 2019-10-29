package com.example.taxipot_android.presenter.ui;

import android.widget.Toast;

import com.example.taxipot_android.di.application.BaseApplication;
import com.example.taxipot_android.domain.entity.User;

import dagger.android.support.DaggerAppCompatActivity;

public class BaseActivity extends DaggerAppCompatActivity {
    protected void makeToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public User getUser() {
        return BaseApplication.getUser();
    }

    public void setUser(User user) {
        BaseApplication.setUser(user);
    }
}

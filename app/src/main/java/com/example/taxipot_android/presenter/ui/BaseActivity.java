package com.example.taxipot_android.presenter.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.example.taxipot_android.di.application.BaseApplication;
import com.example.taxipot_android.domain.entity.User;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast();
    }

    protected void makeToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public User getUser() {
        return BaseApplication.getUser();
    }

    public void setUser(User user) {
        BaseApplication.setUser(user);
    }

    protected abstract void showToast();

    protected Observer<String> toastObserver = new Observer<String>() {
        @Override
        public void onChanged(String s) {
            makeToast(s);
        }
    };
}

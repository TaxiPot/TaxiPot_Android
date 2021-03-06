package com.example.taxipot_android.di.application;

import com.example.taxipot_android.di.component.DaggerBaseComponent;
import com.example.taxipot_android.domain.entity.User;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication {
    AndroidInjector<? extends DaggerApplication> component = null;
    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        BaseApplication.user = user;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        if(component==null){
            component = DaggerBaseComponent.factory().create(this);
        }
        return component;
    }
}

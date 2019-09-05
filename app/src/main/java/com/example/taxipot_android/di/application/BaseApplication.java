package com.example.taxipot_android.di.application;

import com.example.taxipot_android.di.component.DaggerBaseComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication {
    AndroidInjector<? extends DaggerApplication> component = null;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        if(component==null){
            component = DaggerBaseComponent.factory().build(this);
        }
        return component;
    }
}

/*
class BaseApplication() : DaggerApplication(){
    private val component = DaggerBaseComponent.factory().build(this)

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = component
}
 */

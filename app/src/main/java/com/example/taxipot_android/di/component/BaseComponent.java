package com.example.taxipot_android.di.component;

import com.example.taxipot_android.di.application.BaseApplication;
import com.example.taxipot_android.di.module.ActivityBindModule;
import com.example.taxipot_android.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBindModule.class
})
public interface BaseComponent extends AndroidInjector<BaseApplication> {

    @Component.Factory
    interface Factory {
        BaseComponent create(@BindsInstance BaseApplication application);
    }
}
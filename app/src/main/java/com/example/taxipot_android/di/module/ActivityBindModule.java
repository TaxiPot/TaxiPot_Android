package com.example.taxipot_android.di.module;

import com.example.taxipot_android.di.ActivityScope;
import com.example.taxipot_android.di.module.SignIn.SignInActivityModule;
import com.example.taxipot_android.presenter.ui.activity.SignInActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = SignInActivityModule.class)
    abstract SignInActivity provideSignInActivity();
}

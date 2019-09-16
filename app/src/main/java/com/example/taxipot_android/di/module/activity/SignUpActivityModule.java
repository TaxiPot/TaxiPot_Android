package com.example.taxipot_android.di.module.activity;

import com.example.taxipot_android.presenter.viewModelFactory.SignUpViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class SignUpActivityModule {

    @Provides
    SignUpViewModelFactory provideViewModelFactory() {
        return new SignUpViewModelFactory();
    }
}

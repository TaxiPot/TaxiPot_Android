package com.example.taxipot_android.di.module.activity;

import com.example.taxipot_android.presenter.viewModelFactory.SelectLocationViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class SelectLocationActivityModule {
    @Provides
    public SelectLocationViewModelFactory provideViewModel() {
        return new SelectLocationViewModelFactory();
    }
}

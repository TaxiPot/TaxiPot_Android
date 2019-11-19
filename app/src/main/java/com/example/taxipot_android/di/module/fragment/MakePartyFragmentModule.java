package com.example.taxipot_android.di.module.fragment;

import com.example.taxipot_android.presenter.viewModelFactory.MakePartyViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class MakePartyFragmentModule {
    @Provides
    public MakePartyViewModelFactory factory() {
        return new MakePartyViewModelFactory();
    }
}

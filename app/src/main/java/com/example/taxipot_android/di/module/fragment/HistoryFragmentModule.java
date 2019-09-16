package com.example.taxipot_android.di.module.fragment;
import com.example.taxipot_android.presenter.viewModelFactory.HistoryViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class HistoryFragmentModule {
    @Provides
    public HistoryViewModelFactory provideViewModelFactory() {
        return new HistoryViewModelFactory();
    }
}

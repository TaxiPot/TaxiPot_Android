package com.example.taxipot_android.di.module.activity;

import com.example.taxipot_android.di.FragmentScope;
import com.example.taxipot_android.di.module.fragment.MakePartyFragmentModule;
import com.example.taxipot_android.presenter.ui.fragment.MakePartyFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MakePartyActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = MakePartyFragmentModule.class)
    abstract MakePartyFragment provideMakePartyFragment();
}

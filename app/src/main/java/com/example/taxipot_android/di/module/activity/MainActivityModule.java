package com.example.taxipot_android.di.module.activity;

import com.example.taxipot_android.di.ActivityScope;
import com.example.taxipot_android.di.FragmentScope;
import com.example.taxipot_android.presenter.ui.fragment.HomeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {


    @FragmentScope
    @ContributesAndroidInjector
    abstract HomeFragment provideMainHomeFragment();
}

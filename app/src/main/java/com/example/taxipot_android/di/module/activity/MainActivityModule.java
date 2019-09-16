package com.example.taxipot_android.di.module.activity;

import com.example.taxipot_android.di.FragmentScope;
import com.example.taxipot_android.di.module.fragment.HistoryFragmentModule;
import com.example.taxipot_android.di.module.fragment.HomeFragmentModule;
import com.example.taxipot_android.di.module.fragment.MyPageFragmentModule;
import com.example.taxipot_android.di.module.fragment.SettingFragmentModule;
import com.example.taxipot_android.presenter.ui.fragment.HistoryFragment;
import com.example.taxipot_android.presenter.ui.fragment.HomeFragment;
import com.example.taxipot_android.presenter.ui.fragment.MyPageFragment;
import com.example.taxipot_android.presenter.ui.fragment.SettingFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = HomeFragmentModule.class)
    abstract HomeFragment provideHomeFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = SettingFragmentModule.class)
    abstract SettingFragment provideSettingFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = MyPageFragmentModule.class)
    abstract MyPageFragment provideMyPageFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = HistoryFragmentModule.class)
    abstract HistoryFragment provideHistoryFragment();
}

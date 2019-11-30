package com.example.taxipot_android.di.module.activity;

import com.example.taxipot_android.di.FragmentScope;
import com.example.taxipot_android.di.module.fragment.MakePartyFragmentModule;
import com.example.taxipot_android.di.module.fragment.MakePartySeatFragmentModule;
import com.example.taxipot_android.presenter.ui.fragment.ChattingFragment;
import com.example.taxipot_android.presenter.ui.fragment.MakePartyFragment;
import com.example.taxipot_android.presenter.ui.fragment.MakePartySeatFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MakePartyActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = MakePartyFragmentModule.class)
    abstract MakePartyFragment provideMakePartyFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = MakePartySeatFragmentModule.class)
    abstract MakePartySeatFragment provideMakePartySeatFragment();

}

package com.example.taxipot_android.di.module.activity;

import com.example.taxipot_android.di.FragmentScope;
import com.example.taxipot_android.di.module.fragment.ConfirmTaxiPotModule;
import com.example.taxipot_android.di.module.fragment.MakePartySeatFragmentModule;
import com.example.taxipot_android.di.module.fragment.SelectArriveFragmentModule;
import com.example.taxipot_android.di.module.fragment.SelectDepartureFragmentModule;
import com.example.taxipot_android.presenter.ui.fragment.ConfirmArriveFragment;
import com.example.taxipot_android.presenter.ui.fragment.ConfirmDepartureFragment;
import com.example.taxipot_android.presenter.ui.fragment.MakePartySeatFragment;
import com.example.taxipot_android.presenter.ui.fragment.SelectArriveFragment;
import com.example.taxipot_android.presenter.ui.fragment.SelectDepartureFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FindPartyActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = SelectDepartureFragmentModule.class)
    abstract SelectDepartureFragment provideSelectDepartureFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = SelectArriveFragmentModule.class)
    abstract SelectArriveFragment selectArriveFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = ConfirmTaxiPotModule.class)
    abstract ConfirmDepartureFragment departureFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = ConfirmTaxiPotModule.class)
    abstract ConfirmArriveFragment arriveFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = MakePartySeatFragmentModule.class)
    abstract MakePartySeatFragment provideMakePartySeatFragment();
}

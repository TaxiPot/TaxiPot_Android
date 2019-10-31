package com.example.taxipot_android.di.module.activity;

import com.example.taxipot_android.di.FragmentScope;
import com.example.taxipot_android.di.module.fragment.ReportSelReasonFragmentModule;
import com.example.taxipot_android.di.module.fragment.ReportSelSeatFragmentModule;
import com.example.taxipot_android.presenter.ui.fragment.ReportSelReasonFragment;
import com.example.taxipot_android.presenter.ui.fragment.ReportSelSeatFragment;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ReportActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = ReportSelReasonFragmentModule.class)
    abstract ReportSelReasonFragment provideReportSelReasonFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = ReportSelSeatFragmentModule.class)
    abstract ReportSelSeatFragment provideReportSelSeatFragment();

}

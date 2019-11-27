package com.example.taxipot_android.di.module;

import com.example.taxipot_android.di.ActivityScope;
import com.example.taxipot_android.di.module.activity.FindPartyActivityModule;
import com.example.taxipot_android.di.module.activity.MainActivityModule;
import com.example.taxipot_android.di.module.activity.MakePartyActivityModule;
import com.example.taxipot_android.di.module.activity.ReportActivityModule;
import com.example.taxipot_android.di.module.activity.SelectLocationActivityModule;
import com.example.taxipot_android.di.module.activity.SignInActivityModule;
import com.example.taxipot_android.di.module.activity.SignUpActivityModule;
import com.example.taxipot_android.presenter.ui.activity.FindPartyActivity;
import com.example.taxipot_android.presenter.ui.activity.MainActivity;
import com.example.taxipot_android.presenter.ui.activity.MakePartyActivity;
import com.example.taxipot_android.presenter.ui.activity.ReportActivity;
import com.example.taxipot_android.presenter.ui.activity.SelectLocationActivity;
import com.example.taxipot_android.presenter.ui.activity.SignInActivity;
import com.example.taxipot_android.presenter.ui.activity.SignUpActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = SignInActivityModule.class)
    abstract SignInActivity provideSignInActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = SignUpActivityModule.class)
    abstract SignUpActivity provideSignUpActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = SelectLocationActivityModule.class)
    abstract SelectLocationActivity provideSelectLocationActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity provideMainActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = ReportActivityModule.class)
    abstract ReportActivity provideReportActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = MakePartyActivityModule.class)
    abstract MakePartyActivity provideMakePartyActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = FindPartyActivityModule.class)
    abstract FindPartyActivity provideFindPartyActivity();
}

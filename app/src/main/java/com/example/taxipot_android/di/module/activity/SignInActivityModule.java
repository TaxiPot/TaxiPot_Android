package com.example.taxipot_android.di.module.activity;

import dagger.Module;
import dagger.Provides;

@Module
public class SignInActivityModule {
    @Provides
    String provideString() {
        return "Aa";
    }
}

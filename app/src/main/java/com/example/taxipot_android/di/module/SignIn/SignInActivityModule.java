package com.example.taxipot_android.di.module.SignIn;

import dagger.Module;
import dagger.Provides;

@Module
public class SignInActivityModule {
    @Provides
    String provideString() {
        return "Aa";
    }
}

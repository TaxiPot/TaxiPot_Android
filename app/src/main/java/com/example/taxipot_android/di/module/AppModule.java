package com.example.taxipot_android.di.module;

import android.app.Application;
import android.content.Context;

import com.example.taxipot_android.di.application.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    @Singleton
    Context provideContext(BaseApplication application){
        return application;
    }

    @Provides
    @Singleton
    Application provideApplication(BaseApplication application){
        return application;
    }
}


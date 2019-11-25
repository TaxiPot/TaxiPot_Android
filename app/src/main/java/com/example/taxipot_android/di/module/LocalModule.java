package com.example.taxipot_android.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;

@Module
public class LocalModule {
    @Provides
    public SharedPreferences sharedPreferences(Context context) {
        return context.getSharedPreferences("preference",Context.MODE_PRIVATE);
    }
}

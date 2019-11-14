package com.example.taxipot_android.di.module;

import com.example.taxipot_android.data.cache.HistoryCache;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CacheModule {
    @Singleton
    @Provides
    public HistoryCache cache() {
        return new HistoryCache();
    }
}

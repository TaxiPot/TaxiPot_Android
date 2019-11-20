package com.example.taxipot_android.di.module;

import com.example.taxipot_android.data.cache.HistoryCache;
import com.example.taxipot_android.data.cache.ReportCache;
import com.example.taxipot_android.data.cache.TaxiPotCache;

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

    @Singleton
    @Provides
    public ReportCache reportCache() { return new ReportCache(); }

    @Singleton
    @Provides
    public TaxiPotCache taxiPotCache() {return new TaxiPotCache(); }
}

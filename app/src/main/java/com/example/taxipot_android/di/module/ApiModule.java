package com.example.taxipot_android.di.module;

import com.example.taxipot_android.data.api.BugApi;
import com.example.taxipot_android.data.api.HistoryApi;
import com.example.taxipot_android.data.api.ReportApi;
import com.example.taxipot_android.data.api.TaxipotApi;
import com.example.taxipot_android.data.api.UserApi;
import com.example.taxipot_android.util.CreateRetrofit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {
    @Provides
    @Singleton
    public UserApi provideUserApi() {
        return CreateRetrofit.createRetrofit(UserApi.class);
    }

    @Provides
    @Singleton
    public TaxipotApi provideTaxipot() {
        return CreateRetrofit.createRetrofit(TaxipotApi.class);
    }

    @Provides
    @Singleton
    public ReportApi provideReport() {
        return CreateRetrofit.createRetrofit(ReportApi.class);
    }

    @Provides
    @Singleton
    public HistoryApi provideHistory() {
        return CreateRetrofit.createRetrofit(HistoryApi.class);
    }

    @Provides
    @Singleton
    public BugApi provideBug() {
        return CreateRetrofit.createRetrofit(BugApi.class);
    }
}

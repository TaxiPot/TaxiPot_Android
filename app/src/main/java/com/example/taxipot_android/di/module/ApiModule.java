package com.example.taxipot_android.di.module;

import android.util.Log;

import com.example.taxipot_android.data.api.BugApi;
import com.example.taxipot_android.data.api.HistoryApi;
import com.example.taxipot_android.data.api.ReportApi;
import com.example.taxipot_android.data.api.TaxipotApi;
import com.example.taxipot_android.data.api.UserApi;
import com.example.taxipot_android.data.datasource.BugDataSource;
import com.example.taxipot_android.data.datasource.HistoryDataSource;
import com.example.taxipot_android.data.datasource.ReportDataSource;
import com.example.taxipot_android.data.datasource.TaxiPotDataSource;
import com.example.taxipot_android.data.datasource.UserDataSource;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.data.remote.RemoteAPIImpl;
import com.example.taxipot_android.util.CreateRetrofit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {
    @Provides
    @Singleton
    public UserApi provideUserApi() {
        return new CreateRetrofit().createRetrofit(UserApi.class);
    }

    @Provides
    @Singleton
    public TaxipotApi provideTaxipot() {
        return new CreateRetrofit().createRetrofit(TaxipotApi.class);
    }

    @Provides
    @Singleton
    public ReportApi provideReport() {
        return new CreateRetrofit().createRetrofit(ReportApi.class);
    }

    @Provides
    @Singleton
    public HistoryApi provideHistory() {
        Log.e(ApiModule.class.getSimpleName(),"provideHistory");
        return new CreateRetrofit().createRetrofit(HistoryApi.class);
    }

    @Provides
    @Singleton
    public BugApi provideBug() {
        return new CreateRetrofit().createRetrofit(BugApi.class);
    }

    @Provides
    @Singleton
    public UserDataSource userDataSource(UserApi api) {
        return new UserDataSource(api);
    }

    @Provides
    @Singleton
    public TaxiPotDataSource taxiPotDataSource(TaxipotApi api) {
        return new TaxiPotDataSource(api);
    }

    @Provides
    @Singleton
    public ReportDataSource reportDataSource(ReportApi api) {
        return new ReportDataSource(api);
    }

    @Provides
    @Singleton
    public HistoryDataSource historyDataSource(HistoryApi api) {
        return new HistoryDataSource(api);
    }

    @Provides
    @Singleton
    public BugDataSource bugDataSource(BugApi api) {
        return new BugDataSource(api);
    }

    @Provides
    @Singleton
    public RemoteAPI remoteAPI(UserDataSource user, TaxiPotDataSource taxi, HistoryDataSource history, ReportDataSource report, BugDataSource bug) {
        return new RemoteAPIImpl(user,taxi,report,history,bug);
    }
}

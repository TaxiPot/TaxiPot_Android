package com.example.taxipot_android.di.module;

import android.content.Context;
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
import com.example.taxipot_android.data.remote.WebSocketHandler;
import com.example.taxipot_android.util.CreateRetrofit;
import com.example.taxipot_android.util.MapPosition;

import org.java_websocket.client.WebSocketClient;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    private final static String webSocketURI = "ws://10.0.2.2:8080/ws/socket";

    @Provides
    @Singleton
    public URI uri() {
        try {
            return new URI(webSocketURI);
        } catch (URISyntaxException e) {
            return null;
        }
    }

    @Provides
    @Singleton
    public MapPosition mapPosition(Context context) {
        return new MapPosition(context);
    }

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
        Log.e(ApiModule.class.getSimpleName(), "provideHistory");
        return CreateRetrofit.createRetrofit(HistoryApi.class);
    }

    @Provides
    @Singleton
    public BugApi provideBug() {
        return CreateRetrofit.createRetrofit(BugApi.class);
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
        return new RemoteAPIImpl(user, taxi, report, history, bug);
    }
}

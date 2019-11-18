package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.cache.HistoryCache;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.domain.repository.ReportSelSeatRepository;

import io.reactivex.Single;

public class ReportSelSeatRepositoryImpl implements ReportSelSeatRepository {
    RemoteAPI api;
    HistoryCache historyCache;

    public ReportSelSeatRepositoryImpl(RemoteAPI api, HistoryCache historyCache) {
        this.api = api;
        this.historyCache = historyCache;
    }

    public Single<History> getHistory() {
        return historyCache.getHistory();
    }
}

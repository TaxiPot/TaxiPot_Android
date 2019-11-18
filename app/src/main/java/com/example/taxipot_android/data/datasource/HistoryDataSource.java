package com.example.taxipot_android.data.datasource;

import android.util.Log;

import com.example.taxipot_android.data.api.HistoryApi;
import com.example.taxipot_android.domain.entity.History;

import java.util.List;

import io.reactivex.Observable;

public class HistoryDataSource {
    private HistoryApi api;
    public HistoryDataSource(HistoryApi api) {
        this.api = api;
    }

    public Observable<List<History>> findHistoryById(String userId) {
        return api.findHistoryById(userId);
    }

    public Observable<Integer> sendHistoryList(String userId, List<History> saveList) {
        return api.sendHistoryList(userId,saveList);
    }
}

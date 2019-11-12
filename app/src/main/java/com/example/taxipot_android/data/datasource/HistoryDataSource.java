package com.example.taxipot_android.data.datasource;

import com.example.taxipot_android.data.api.HistoryApi;
import com.example.taxipot_android.domain.entity.History;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HistoryDataSource {
    private HistoryApi api;
    public HistoryDataSource(HistoryApi api) {
        this.api = api;
    }

    public Observable<History> findHistoryById(String userId) {
        return api.findHistoryById(userId)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Integer> sendHistoryList(String userId, List<History> saveList) {
        return api.sendHistoryList(userId,saveList)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread());
    }
}

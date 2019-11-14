package com.example.taxipot_android.data.repository;

import android.util.Log;

import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.domain.repository.HistoryRepository;

import java.util.List;

import io.reactivex.Observable;

public class HistoryRepositoryImpl implements HistoryRepository {
    RemoteAPI api;

    public HistoryRepositoryImpl(RemoteAPI api) {
        this.api = api;
    }

    @Override
    public Observable<List<History>> getHistories(String userId) {
        Log.e(this.getClass().getSimpleName(),"getHistories");
        return api.findHistoryById(userId);
    }
}

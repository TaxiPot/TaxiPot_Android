package com.example.taxipot_android.data.repository;

import android.location.Address;
import android.util.Log;

import com.example.taxipot_android.data.cache.HistoryCache;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.domain.repository.HistoryRepository;
import com.example.taxipot_android.util.MapPosition;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class HistoryRepositoryImpl implements HistoryRepository {
    RemoteAPI api;
    HistoryCache cache;
    MapPosition mapPosition;

    public HistoryRepositoryImpl(RemoteAPI api, HistoryCache cache, MapPosition mapPosition) {
        this.api = api;
        this.cache = cache;
        this.mapPosition = mapPosition;
    }

    @Override
    public Observable<List<History>> getHistories(String userId) {
        Log.e(this.getClass().getSimpleName(),"getHistories");
        return api.findHistoryById(userId)
                .map(new Function<List<History>, List<History>>() {
                    @Override
                    public List<History> apply(List<History> histories) throws Exception {
                        return cache.saveHistories(mapPosition.historiesTransForm(histories));
                    }
                });
    }

    @Override
    public void saveToReport(History history) {
        cache.setHistory(history);
    }
}

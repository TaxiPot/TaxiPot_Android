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
    public Observable<History> getHistories(String userId) {
        return api.findHistoryById(userId)
                .map(new Function<List<History>, List<History>>() {
                    @Override
                    public List<History> apply(List<History> histories) throws Exception {
                        return cache.saveHistories(histories);
                    }
                })
                .flatMapIterable(new Function<List<History>, Iterable<? extends History>>() {
                    @Override
                    public Iterable<? extends History> apply(List<History> histories) throws Exception {
                        return histories;
                    }
                })
                .map(new Function<History, History>() {
                    @Override
                    public History apply(History history) throws Exception {
                        return putAddress(history);
                    }
                });
    }

    private History putAddress(History history) {

        try {
            Address startAdd = mapPosition.coordinateToLocate(history.getStart_latitude(), history.getStart_longtitude());
            String start = mapPosition.getLocateFromAddress(startAdd);
            history.setStart(start);
        } catch (Exception e) {
            Log.e(this.getClass().getSimpleName(),e.getMessage());
            history.setStart("위치 찾을 수 없음");
        }
        try {
            Address endAdd = mapPosition.coordinateToLocate(history.getEnd_latitude(), history.getEnd_longtitude());
            String end = mapPosition.getLocateFromAddress(endAdd);
            history.setFinish(end);
        } catch (Exception e) {
            Log.e(this.getClass().getSimpleName(),e.getMessage());
            history.setFinish("위치 찾을 수 없음");
        }
        return history;
    }

    @Override
    public void saveToReport(History history) {
        cache.setHistory(history);
    }
}

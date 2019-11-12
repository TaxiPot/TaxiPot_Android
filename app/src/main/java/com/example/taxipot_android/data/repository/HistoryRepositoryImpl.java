package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.domain.repository.HistoryRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

public class HistoryRepositoryImpl implements HistoryRepository {
    RemoteAPI api;

    public HistoryRepositoryImpl(RemoteAPI api) {
        this.api = api;
    }

    @Override
    public Observable<History> getHistories(String userId) {
        api.findHistoryById(userId).map(
                new Function<History, Integer>() {
                    @Override
                    public Integer apply(History history) throws Exception {
                        return history.getUserRoomId().getRoomId();
                    }
                }
        ).reduce(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) throws Exception {
                return null;
            }
        })
    }
}

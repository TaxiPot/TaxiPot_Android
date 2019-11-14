package com.example.taxipot_android.domain.repository;

import com.example.taxipot_android.domain.entity.History;

import java.util.List;

import io.reactivex.Observable;

public interface HistoryRepository {
    Observable<List<History>> getHistories(String userId);
}

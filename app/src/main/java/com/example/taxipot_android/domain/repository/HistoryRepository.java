package com.example.taxipot_android.domain.repository;

import android.location.Address;

import com.example.taxipot_android.domain.entity.History;

import java.util.List;

import io.reactivex.Observable;

public interface HistoryRepository {
    Observable<List<History>> getHistories(String userId);
    void saveToReport(History history);
}

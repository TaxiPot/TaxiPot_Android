package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.domain.repository.HistoryRepository;

public class HistoryRepositoryImpl implements HistoryRepository {
    RemoteAPI api;

    public HistoryRepositoryImpl(RemoteAPI api) {
        this.api = api;
    }
}

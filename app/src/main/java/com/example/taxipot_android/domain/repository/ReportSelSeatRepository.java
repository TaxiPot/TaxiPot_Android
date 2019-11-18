package com.example.taxipot_android.domain.repository;

import com.example.taxipot_android.domain.entity.History;

import io.reactivex.Single;

public interface ReportSelSeatRepository {
    public Single<History> getHistory();
}

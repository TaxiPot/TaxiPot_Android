package com.example.taxipot_android.domain.repository;

import com.example.taxipot_android.domain.entity.Report;

import io.reactivex.Observable;

public interface ReportSelReasonRepository {
    Observable<Report> doReport(int num);
}

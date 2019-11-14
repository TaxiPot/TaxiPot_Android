package com.example.taxipot_android.data.datasource;

import com.example.taxipot_android.data.api.ReportApi;
import com.example.taxipot_android.domain.entity.Report;

import io.reactivex.Observable;

public class ReportDataSource {
    private ReportApi api;
    public ReportDataSource(ReportApi api) {
        this.api = api;
    }

    public Observable<Report> sendReport(Report report) {
        return api.sendReport(report);
    }
}

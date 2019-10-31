package com.example.taxipot_android.data.datasource;

import com.example.taxipot_android.data.api.ReportApi;
import com.example.taxipot_android.domain.entity.Report;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ReportDataSource {
    private ReportApi api;
    public ReportDataSource(ReportApi api) {
        this.api = api;
    }

    public Observable<Report> sendReport(Report report) {
        return api.sendReport(report)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread());
    }
}

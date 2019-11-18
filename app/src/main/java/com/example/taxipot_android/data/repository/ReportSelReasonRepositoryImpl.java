package com.example.taxipot_android.data.repository;

import android.util.Log;

import com.example.taxipot_android.data.cache.ReportCache;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.domain.entity.Report;
import com.example.taxipot_android.domain.repository.ReportSelReasonRepository;

import io.reactivex.Observable;

public class ReportSelReasonRepositoryImpl implements ReportSelReasonRepository {

    private RemoteAPI api;
    private ReportCache cache;

    public ReportSelReasonRepositoryImpl(RemoteAPI api, ReportCache cache) {
        this.api = api;
        this.cache = cache;
    }

    @Override
    public Observable<Report> doReport(int num) {
        if(num==-1) return Observable.error(new ArrayIndexOutOfBoundsException("신고 사유를 선택해주세요."));
        Report report = new Report(num,cache.getReportId(),cache.getReportedId());
        Log.e(this.getClass().getSimpleName(),report.toString());
        return api.sendReport(report);
    }
}

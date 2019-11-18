package com.example.taxipot_android.data.api;

import com.example.taxipot_android.domain.entity.Report;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ReportApi {
    @POST("/api/reports/report")
    Observable<Report> sendReport(@Body Report report);
}

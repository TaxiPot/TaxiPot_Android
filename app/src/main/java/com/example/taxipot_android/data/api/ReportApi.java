package com.example.taxipot_android.data.api;

import com.example.taxipot_android.domain.entity.Report;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ReportApi {
    @POST
    Observable<Report> sendReport(@Body Report report);
}

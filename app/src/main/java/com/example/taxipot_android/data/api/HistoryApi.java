package com.example.taxipot_android.data.api;

import com.example.taxipot_android.domain.entity.History;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface HistoryApi {
    @GET("/api/histories/{id}/history")
    Observable<List<History>> findHistoryById(@Path("id") String userId);

    @POST("/api/histories/{id}/history")
    Observable<Integer> sendHistoryList(@Path("id") String id, @Body List<History> historyList);
}

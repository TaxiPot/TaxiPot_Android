package com.example.taxipot_android.data.api;

import com.example.taxipot_android.domain.entity.History;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HistoryApi {
    @GET("/{id}/history")
    Observable<History> findHistoryById(@Path("id") String userId);

    @POST("{id}/history")
    Observable<Integer> sendHistoryList(@Path("id") String id, @Body List<History> historyList);
}

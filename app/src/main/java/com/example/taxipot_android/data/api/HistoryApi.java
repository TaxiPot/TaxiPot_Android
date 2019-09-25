package com.example.taxipot_android.data.api;

import com.example.taxipot_android.domain.entity.History;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface HistoryApi {
    @GET
    Observable<List<History>> findHistoryById(@Query("id") String userId);

    @POST
    Observable<Boolean> sendHistoryList(@Query("historyList") List<History> historyList, @Query("id") String id);
}

package com.example.taxipot_android.data.api;

import com.example.taxipot_android.domain.entity.Bug;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BugApi {
    @POST
    Observable<Void> postBug(@Query("bugReport") Bug bug);
}

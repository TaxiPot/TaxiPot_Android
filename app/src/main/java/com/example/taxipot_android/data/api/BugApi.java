package com.example.taxipot_android.data.api;

import com.example.taxipot_android.domain.entity.Bug;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface BugApi {
    @POST
    Single<Bug> postBug(@Body Bug bug);
}

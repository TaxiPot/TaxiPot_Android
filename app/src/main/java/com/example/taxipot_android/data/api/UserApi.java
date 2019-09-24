package com.example.taxipot_android.data.api;

import com.example.taxipot_android.domain.entity.User;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserApi {
    @POST
    Observable<User> requestSignIn(@Body User user);

    @POST
    Observable<User> requestSignUp(@Body User user);

    @PATCH
    Observable<Void> changePassword(@Query("fromPW") String fromPW, @Query("toPW") String toPW, @Query("user_id") String id);
}

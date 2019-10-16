package com.example.taxipot_android.data.api;

import com.example.taxipot_android.domain.entity.User;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserApi {
    @POST("/api/users/signin")
    Observable<User> requestSignIn(@Body User user);

    @POST("/api/users/signup")
    Observable<Void> requestSignUp(@Body User user);

    @PATCH("/api/users/{user_id}/change_pw")
    Observable<Void> changePassword(@Query("fromPW") String fromPW, @Query("toPW") String toPW, @Path("user_id") String user_id);
}

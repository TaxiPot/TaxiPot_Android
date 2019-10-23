package com.example.taxipot_android.data.api;

import com.example.taxipot_android.domain.entity.User;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserApi {
    @POST
    Single<User> requestSignIn(@Body User user);

    @POST("/api/users/signup")
    Single<User> requestSignUp(@Body User user);
    
    @PATCH("/api/users/{user_id}/change_pw")
    Observable<User> changePassword(@Path("user_id") String user_id, @Query("fromPW") String fromPW, @Query("toPW") String toPW);
}

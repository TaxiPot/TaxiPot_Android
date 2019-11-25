package com.example.taxipot_android.data.api;

import com.example.taxipot_android.domain.entity.TaxiPot;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TaxipotApi {

    @PATCH("/api/rooms/{roomId}/join")
    Single<TaxiPot> joinToTaxipot(@Path("roomId") int roomId, @Query("user_id") String userId, @Query("seat_num") int seatNum);

    @GET("/api/rooms/findRoom")
    Observable<List<TaxiPot>> findTaxipotList(@Query("depart_time") long departTime,
                                              @Query("start_latitude") double startLatitude,
                                              @Query("start_longitude") double startLongitude,
                                              @Query("end_latitude") double endLatitude,
                                              @Query("end_longitude") double endLongitude,
                                              @Query("radius") float radius,
                                              @Query("age") int age,
                                              @Query("isMan") boolean isMan);

    @POST("/api/rooms/makeroom")
    Single<TaxiPot> makeTaxipot(@Body TaxiPot taxiPot);
}

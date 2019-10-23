package com.example.taxipot_android.data.api;

import com.example.taxipot_android.domain.entity.TaxiPot;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TaxipotApi {

    @PATCH("/api/rooms/{roomId}/join")
    Observable<TaxiPot> joinToTaxipot(@Path("roomId") String roomId, @Query("seat_num") String seatNum, @Query("user_id") String userId);
    
    @GET("/api/rooms/findRoom")
    Observable<TaxiPot> findTaxipotList();
    
    @POST("/api/rooms/makeroom")
    Observable<TaxiPot> makeTaxipot(@Body TaxiPot taxiPot);
    }

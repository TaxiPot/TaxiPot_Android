package com.example.taxipot_android.data.api;

import com.example.taxipot_android.domain.entity.TaxiPot;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TaxipotApi {
    @PATCH
    Observable<Void> joinToTaxipot(@Query("roomId") String roomId, @Query("seat_num") String seatNum, @Query("user_id") String userId);

    @GET
    Observable<TaxiPot> findTaxipotList();

    @POST
    Observable<Void> makeTaxipot(@Query("taxiPot") TaxiPot taxiPot);
}

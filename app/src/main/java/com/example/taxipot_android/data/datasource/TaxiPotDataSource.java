package com.example.taxipot_android.data.datasource;

import com.example.taxipot_android.data.api.TaxipotApi;
import com.example.taxipot_android.domain.entity.TaxiPot;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TaxiPotDataSource {
    TaxipotApi api;
    TaxiPotDataSource(TaxipotApi api) {
        this.api = api;
    }

    public Observable<TaxiPot> findTaxiPotList(TaxiPot taxiPot, float radius, int age) {
        return api.findTaxipotList(taxiPot.getDepartTime().getTime().getTime(),
                taxiPot.getStartLatitude(),
                taxiPot.getStartLongtitude(),
                taxiPot.getEndLatitude(),
                taxiPot.getEndLongtitude(),
                radius,
                age);
    }

    public Single<TaxiPot> joinTaxiPot(int roomId, String userId, int seatNum) {
        return api.joinToTaxipot(roomId,userId,seatNum)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread());
    }

    public Single<TaxiPot> makeTaxiPot(TaxiPot taxiPot) {
        return api.makeTaxipot(taxiPot)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread());
    }
}
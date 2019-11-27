package com.example.taxipot_android.data.cache;

import android.util.Log;

import com.example.taxipot_android.domain.entity.TaxiPot;

import java.util.List;

import io.reactivex.Observable;

public class TaxiPotCache {
    private TaxiPot makeTaxiPot;

    public void setMakeTaxiPot(TaxiPot makeTaxiPot) {
        this.makeTaxiPot = makeTaxiPot;
    }

    public TaxiPot getMakeTaxiPot() {
        return makeTaxiPot;
    }

    private List<TaxiPot> findTaxiPot;

    public Observable<TaxiPot> getFindTaxiPot() {
        Log.e(this.getClass().getSimpleName(),"방 리스트 개수 : " + findTaxiPot.size() + "\n");
        return Observable.fromIterable(findTaxiPot);
    }

    public void setFindTaxiPot(List<TaxiPot> findTaxiPot) {
        this.findTaxiPot = findTaxiPot;
    }
}

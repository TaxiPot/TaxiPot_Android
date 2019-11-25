package com.example.taxipot_android.data.cache;

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
        return Observable.fromIterable(findTaxiPot);
    }

    public void setFindTaxiPot(List<TaxiPot> findTaxiPot) {
        this.findTaxiPot = findTaxiPot;
    }
}

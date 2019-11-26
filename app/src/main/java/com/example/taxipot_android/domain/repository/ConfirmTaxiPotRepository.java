package com.example.taxipot_android.domain.repository;

import com.example.taxipot_android.domain.entity.TaxiPot;

import io.reactivex.Observable;

public interface ConfirmTaxiPotRepository {
    Observable<TaxiPot> getTaxiPotSearchResult();

    void cacheTaxiPot(TaxiPot taxiPot);

    TaxiPot getTaxiPot();
}

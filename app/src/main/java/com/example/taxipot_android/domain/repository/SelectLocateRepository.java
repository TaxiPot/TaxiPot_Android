package com.example.taxipot_android.domain.repository;

import com.example.taxipot_android.domain.entity.TaxiPot;

import io.reactivex.Observable;

public interface SelectLocateRepository {
    Observable<TaxiPot> findTaxiPot(TaxiPot taxiPot, float radius);
}

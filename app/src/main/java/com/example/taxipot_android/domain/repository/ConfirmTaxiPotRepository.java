package com.example.taxipot_android.domain.repository;

import com.example.taxipot_android.domain.entity.TaxiPot;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface ConfirmTaxiPotRepository {
    Observable<TaxiPot> getTaxiPotSearchResult();
}

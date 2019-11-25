package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.cache.TaxiPotCache;
import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.repository.ConfirmTaxiPotRepository;

import io.reactivex.Observable;
import io.reactivex.Single;

public class ConfirmTaxiPotRepositoryImpl implements ConfirmTaxiPotRepository {
    TaxiPotCache cache;

    public ConfirmTaxiPotRepositoryImpl(TaxiPotCache cache) {
        this.cache = cache;
    }

    @Override
    public Observable<TaxiPot> getTaxiPotSearchResult() {
        return cache.getFindTaxiPot();
    }

    @Override
    public void cacheTaxiPot(TaxiPot taxiPot) {
        cache.setMakeTaxiPot(taxiPot);
    }

    @Override
    public TaxiPot getTaxiPot() {
        return cache.getMakeTaxiPot();
    }
}

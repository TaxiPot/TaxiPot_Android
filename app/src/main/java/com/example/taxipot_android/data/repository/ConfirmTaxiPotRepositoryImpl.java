package com.example.taxipot_android.data.repository;

import android.location.Address;
import android.util.Log;

import com.example.taxipot_android.data.cache.TaxiPotCache;
import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.repository.ConfirmTaxiPotRepository;
import com.example.taxipot_android.util.MapPosition;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class ConfirmTaxiPotRepositoryImpl implements ConfirmTaxiPotRepository {
    TaxiPotCache cache;
    MapPosition mapPosition;

    public ConfirmTaxiPotRepositoryImpl(TaxiPotCache cache, MapPosition mapPosition) {
        this.cache = cache;
        this.mapPosition = mapPosition;
    }

    @Override
    public Observable<TaxiPot> getTaxiPotSearchResult() {
        return cache.getFindTaxiPot()
                .map(new Function<TaxiPot, TaxiPot>() {
                    @Override
                    public TaxiPot apply(TaxiPot taxiPot) throws Exception {
                        Address startAdd = mapPosition.coordinateToLocate(taxiPot.getStartLatitude(), taxiPot.getStartLongtitude());
                        Address endAdd = mapPosition.coordinateToLocate(taxiPot.getEndLatitude(), taxiPot.getEndLongtitude());
                        taxiPot.setStart(mapPosition.getLocateFromAddress(startAdd));
                        taxiPot.setFinish(mapPosition.getLocateFromAddress(endAdd));
                        Log.e(this.getClass().getSimpleName(), taxiPot.toString());
                        return taxiPot;
                    }
                });
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

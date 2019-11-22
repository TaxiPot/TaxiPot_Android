package com.example.taxipot_android.data.repository;

import android.app.Application;
import android.location.Address;

import com.example.taxipot_android.data.cache.TaxiPotCache;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.di.application.BaseApplication;
import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.repository.MakePartyRepository;
import com.example.taxipot_android.util.MapPosition;

import java.io.IOException;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class MakePartyRepositoryImpl implements MakePartyRepository {
    RemoteAPI api;
    TaxiPotCache taxiPotCache;
    MapPosition mapPosition;

    public MakePartyRepositoryImpl(RemoteAPI api, TaxiPotCache taxiPotCache, MapPosition mapPosition) {
        this.api = api;
        this.taxiPotCache = taxiPotCache;
        this.mapPosition = mapPosition;
    }

    @Override
    public Address getLocateCoordinate(String locate) throws IOException {
        return mapPosition.locateToCoordinate(locate);
    }

    @Override
    public User getUserInfo() {
        return BaseApplication.getUser();
    }

    @Override
    public Single<TaxiPot> makeTaxiPot(TaxiPot taxiPot) {
        return api.makeTaxipot(taxiPot)
                .map(new Function<TaxiPot, TaxiPot>() {
                    @Override
                    public TaxiPot apply(TaxiPot taxiPot) throws Exception {
                        taxiPotCache.setMakeTaxiPot(taxiPot);
                        return taxiPot;
                    }
                });
    }
}

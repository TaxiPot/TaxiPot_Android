package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.cache.TaxiPotCache;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.di.application.BaseApplication;
import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.repository.SelectLocateRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class SelectLocateRepositoryImpl implements SelectLocateRepository {
    RemoteAPI api;
    TaxiPotCache cache;

    public SelectLocateRepositoryImpl(RemoteAPI api, TaxiPotCache cache) {
        this.api = api;
        this.cache = cache;
    }

    private User getUser() {
        return BaseApplication.getUser();
    }

    @Override
    public Observable<TaxiPot> findTaxiPot(TaxiPot taxiPot, float radius) {
        User user = getUser();
        int age = user.getAge();
        boolean isMan = user.getIsMan();
        return api.findTaxipotList(taxiPot, radius, age, isMan)
                .flatMapIterable(new Function<List<TaxiPot>, Iterable<TaxiPot>>() {
                    @Override
                    public Iterable<TaxiPot> apply(List<TaxiPot> taxiPots) throws Exception {
                        cache.setFindTaxiPot(taxiPots);
                        return taxiPots;
                    }
                });
    }
}

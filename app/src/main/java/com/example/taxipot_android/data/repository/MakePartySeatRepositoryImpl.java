package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.cache.TaxiPotCache;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.di.application.BaseApplication;
import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.repository.MakePartySeatRepository;

import io.reactivex.Single;

public class MakePartySeatRepositoryImpl implements MakePartySeatRepository {
    private TaxiPotCache taxiPotCache;
    private RemoteAPI api;

    @Override
    public User getUser() {
        return BaseApplication.getUser();
    }

    @Override
    public Single<TaxiPot> joinToTaxiPot(int roomId, String userId, int seat_num) {
        return api.joinTaxiPot(roomId,userId,seat_num);
    }
}

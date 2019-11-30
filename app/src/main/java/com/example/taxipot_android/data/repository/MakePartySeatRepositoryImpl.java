package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.cache.TaxiPotCache;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.di.application.BaseApplication;
import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.repository.MakePartySeatRepository;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class MakePartySeatRepositoryImpl implements MakePartySeatRepository {
    private TaxiPotCache taxiPotCache;
    private RemoteAPI api;

    public MakePartySeatRepositoryImpl(TaxiPotCache taxiPotCache, RemoteAPI api) {
        this.taxiPotCache = taxiPotCache;
        this.api = api;
    }

    @Override
    public User getUser() {
        return BaseApplication.getUser();
    }

    @Override
    public Single<TaxiPot> joinToTaxiPot(int roomId, String userId, int seat_num) {
        if(BaseApplication.getUser()==null) return Single.error(new Exception("사용자 정보를 불러오지 못했어요.."));
        return api.joinTaxiPot(roomId,userId,seat_num)
                .map(new Function<TaxiPot, TaxiPot>() {
                    @Override
                    public TaxiPot apply(TaxiPot taxiPot) throws Exception {
                        BaseApplication.getUser().setRoomId(taxiPot.getRoomid());
                        BaseApplication.getUser().setSeatNum(seat_num);
                        return taxiPot;
                    }
                });
    }

    @Override
    public TaxiPot getTaxiPot() {
        return taxiPotCache.getMakeTaxiPot();
    }
}

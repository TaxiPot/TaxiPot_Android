package com.example.taxipot_android.domain.repository;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.entity.User;

import io.reactivex.Single;

public interface MakePartySeatRepository {

    User getUser();

    Single<TaxiPot> joinToTaxiPot(int roomId, String userId, int seat_num);

    TaxiPot getTaxiPot();
}

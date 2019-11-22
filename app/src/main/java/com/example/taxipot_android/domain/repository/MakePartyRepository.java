package com.example.taxipot_android.domain.repository;

import android.location.Address;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.entity.User;

import java.io.IOException;

import io.reactivex.Single;

public interface MakePartyRepository {

    User getUserInfo();

    Single<TaxiPot> makeTaxiPot(TaxiPot taxiPot);

    Address getLocateCoordinate(String locate) throws IOException;
}

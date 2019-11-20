package com.example.taxipot_android.data.validation;

import com.example.taxipot_android.domain.entity.TaxiPot;

import io.reactivex.Single;

public interface MakePartyValidation {
    Single<TaxiPot> makeTaxiPot(TaxiPot taxiPot);
}

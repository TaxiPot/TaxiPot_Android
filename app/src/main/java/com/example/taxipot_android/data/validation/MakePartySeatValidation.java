package com.example.taxipot_android.data.validation;

import com.example.taxipot_android.domain.entity.TaxiPot;

import io.reactivex.Single;

public interface MakePartySeatValidation {
    Single<TaxiPot> joinToTaxiPot(int seat_num);

    TaxiPot getTaxiPot();
}

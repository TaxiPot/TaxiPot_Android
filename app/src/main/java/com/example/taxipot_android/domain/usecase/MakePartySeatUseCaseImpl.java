package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.data.validation.MakePartySeatValidation;
import com.example.taxipot_android.domain.entity.TaxiPot;

import io.reactivex.observers.DisposableSingleObserver;

public class MakePartySeatUseCaseImpl extends MakePartySeatUseCase<TaxiPot> {
    MakePartySeatValidation validation;

    public MakePartySeatUseCaseImpl(MakePartySeatValidation validation) {
        this.validation = validation;
    }

    @Override
    public void joinToTaxiPot(int seat_num, DisposableSingleObserver disposable) {
        execute(validation.joinToTaxiPot(seat_num),disposable);
    }
}

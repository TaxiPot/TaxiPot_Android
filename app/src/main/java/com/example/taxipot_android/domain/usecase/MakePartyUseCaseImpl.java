package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.data.validation.MakePartyValidation;
import com.example.taxipot_android.domain.entity.TaxiPot;

import java.util.Date;

import io.reactivex.observers.DisposableSingleObserver;

public class MakePartyUseCaseImpl extends MakePartyUseCase<TaxiPot> {
    private MakePartyValidation validation;

    public MakePartyUseCaseImpl(MakePartyValidation validation) {
        this.validation = validation;
    }

    @Override
    public void makeTaxiPot(String departure, String arrive, boolean onlySameGender, int ageLowLimit, int ageHighLimit, int year, int month, int day, int hour, int minute, DisposableSingleObserver disposable) {
        Date date = new Date(year-1900,month-1,day,hour,minute);
        long time = date.getTime();
        TaxiPot taxiPot = new TaxiPot(departure, arrive, onlySameGender, ageLowLimit, ageHighLimit, time);
        execute(validation.makeTaxiPot(taxiPot),disposable);
    }
}

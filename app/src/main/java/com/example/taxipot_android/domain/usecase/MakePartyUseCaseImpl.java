package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.data.validation.MakePartyValidation;
import com.example.taxipot_android.domain.entity.TaxiPot;

import java.util.Calendar;
import java.util.Date;

import io.reactivex.Single;
import io.reactivex.observers.DisposableSingleObserver;

public class MakePartyUseCaseImpl extends MakePartyUseCase<TaxiPot> {
    private MakePartyValidation validation;

    public MakePartyUseCaseImpl(MakePartyValidation validation) {
        this.validation = validation;
    }

    @Override
    public void makeTaxiPot(String departure, String arrive, boolean onlySameGender, int ageLowLimit, int ageHighLimit, int year, int month, int day, int hour, int minute, DisposableSingleObserver disposable) {
        long time = new Date(year,month,day,hour,minute).getTime();
        TaxiPot taxiPot = new TaxiPot(departure, arrive, onlySameGender, ageLowLimit, ageHighLimit, time);
        execute(validation.makeTaxiPot(taxiPot),disposable);
    }
}

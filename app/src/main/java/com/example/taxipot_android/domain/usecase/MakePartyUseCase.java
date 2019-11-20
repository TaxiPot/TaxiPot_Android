package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.util.UseCase;

import io.reactivex.observers.DisposableSingleObserver;

public abstract class MakePartyUseCase<T> extends UseCase<T> {
    public abstract void makeTaxiPot(String departure, String arrive, boolean onlySameGender, int ageLowLimit, int ageHighLimit, int year, int month, int day, int hour, int minute, DisposableSingleObserver disposable);
}

package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.util.UseCase;

import io.reactivex.observers.DisposableObserver;

public abstract class SelectLocateUseCase extends UseCase {
    public abstract void findTaxiPots(
            Double departureLatitude,
            Double departureLongitude,
            Double arriveLatitude,
            Double arriveLongitude,
            Float radius,
            Integer hour,
            Integer minute,
            boolean tomorrow,
            DisposableObserver disposable);
}

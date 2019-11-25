package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.util.UseCase;

import io.reactivex.observers.DisposableObserver;

public abstract class SelectLocateUseCase extends UseCase {
    public abstract void findTaxiPots(
            double departureLatitude,
            double departureLongitude,
            double arriveLatitude,
            double arriveLongitude,
            float radius,
            int year,
            int month,
            int day,
            int hour,
            int minute,
            DisposableObserver disposable);
}

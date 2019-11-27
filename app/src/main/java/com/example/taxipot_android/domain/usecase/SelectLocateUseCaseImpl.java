package com.example.taxipot_android.domain.usecase;

import android.util.Log;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.repository.SelectLocateRepository;

import java.util.Date;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

public class SelectLocateUseCaseImpl extends SelectLocateUseCase {

    SelectLocateRepository repository;

    public SelectLocateUseCaseImpl(SelectLocateRepository repository) {
        this.repository = repository;
    }

    @Override
    public void findTaxiPots(Double departureLatitude, Double departureLongitude, Double arriveLatitude, Double arriveLongitude, Float radius, Integer hour, Integer minute, boolean isTomorrow, DisposableObserver disposable) {


        if(departureLatitude==null || departureLongitude==null || arriveLatitude == null || arriveLongitude == null || radius == null || hour == null || minute == null) {
            execute(Observable.error(new Exception("입력되지 않은 값이 있어요.")),disposable);
        } else {
            Date today = new Date();
            Date date;
            if(isTomorrow) {
                date = new Date(today.getYear(), today.getMonth(), today.getDate()+1, hour, minute);
            } else {
                date = new Date(today.getYear(), today.getMonth(), today.getDate(), hour, minute);
            }
            radius = radius / 100000;

            TaxiPot taxiPot = new TaxiPot(departureLongitude, departureLatitude, arriveLongitude, arriveLatitude, date.getTime());

            execute(repository.findTaxiPot(taxiPot, radius), disposable);
        }
    }
}

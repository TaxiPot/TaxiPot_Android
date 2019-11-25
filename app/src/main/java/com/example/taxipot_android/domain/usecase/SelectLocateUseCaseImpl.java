package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.repository.SelectLocateRepository;

import java.util.Date;

import io.reactivex.observers.DisposableObserver;

public class SelectLocateUseCaseImpl extends SelectLocateUseCase {

    SelectLocateRepository repository;

    public SelectLocateUseCaseImpl(SelectLocateRepository repository) {
        this.repository = repository;
    }

    @Override
    public void findTaxiPots(double departureLatitude, double departureLongitude, double arriveLatitude, double arriveLongitude, float radius, int year, int month, int day, int hour, int minute, DisposableObserver disposable) {
        Date date = new Date(year-1900,month-1,day,hour,minute);
        TaxiPot taxiPot = new TaxiPot(departureLongitude,departureLatitude,arriveLongitude,arriveLatitude,date.getTime());
        repository.findTaxiPot(taxiPot,radius);
    }
}

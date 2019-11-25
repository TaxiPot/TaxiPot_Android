package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.repository.ConfirmTaxiPotRepository;

import io.reactivex.observers.DisposableObserver;

public class ConfirmTaxiPotUseCaseImpl extends ConfirmTaxiPotUseCase {

    ConfirmTaxiPotRepository repository;

    public ConfirmTaxiPotUseCaseImpl(ConfirmTaxiPotRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getTaxiPotSearchResult(DisposableObserver disposable) {
        execute(repository.getTaxiPotSearchResult(),disposable);
    }

    @Override
    public void cacheTaxiPot(TaxiPot taxiPot) {
        repository.cacheTaxiPot(taxiPot);
    }

    @Override
    public TaxiPot getTaxiPot() {
        return repository.getTaxiPot();
    }
}

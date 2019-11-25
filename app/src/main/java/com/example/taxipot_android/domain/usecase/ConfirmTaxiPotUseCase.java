package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.util.UseCase;

import io.reactivex.observers.DisposableObserver;

public abstract class ConfirmTaxiPotUseCase extends UseCase {
    public abstract void getTaxiPotSearchResult(DisposableObserver disposable);
}

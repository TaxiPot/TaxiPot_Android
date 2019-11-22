package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.util.UseCase;

import io.reactivex.observers.DisposableSingleObserver;

public abstract class MakePartySeatUseCase<T> extends UseCase<T> {
    public abstract void joinToTaxiPot(int seat_num, DisposableSingleObserver disposable);
}

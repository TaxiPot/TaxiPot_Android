package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.util.UseCase;

import io.reactivex.observers.DisposableObserver;

public abstract class ReportSelReasonUseCase<T> extends UseCase<T> {
    public abstract void doReport(int num, DisposableObserver disposable);
}

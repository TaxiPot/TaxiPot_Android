package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.util.UseCase;

import io.reactivex.observers.DisposableSingleObserver;

public abstract class ReportSelSeatUseCase<T> extends UseCase<T> {
    public abstract void getHistory(DisposableSingleObserver disposable);

    public abstract void saveReportUser(History history, Integer seatNum, DisposableSingleObserver disposable);
}

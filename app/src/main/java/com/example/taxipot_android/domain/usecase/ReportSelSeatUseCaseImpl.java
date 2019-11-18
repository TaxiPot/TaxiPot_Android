package com.example.taxipot_android.domain.usecase;

import android.util.Log;

import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.domain.repository.ReportSelSeatRepository;

import io.reactivex.observers.DisposableSingleObserver;

public class ReportSelSeatUseCaseImpl extends ReportSelSeatUseCase<History> {
    ReportSelSeatRepository repository;

    public ReportSelSeatUseCaseImpl(ReportSelSeatRepository repository) {
        this.repository = repository;
    }

    public void getHistory(DisposableSingleObserver disposable) {
        Log.e(this.getClass().getSimpleName(),"getHistory");
        execute(repository.getHistory(),disposable);
    }

    @Override
    public void saveReportUser(History history, Integer seatNum, DisposableSingleObserver disposable) {
        execute(repository.saveReportUser(history,seatNum),disposable);
    }
}

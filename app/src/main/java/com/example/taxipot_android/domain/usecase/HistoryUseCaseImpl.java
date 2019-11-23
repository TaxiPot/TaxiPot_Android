package com.example.taxipot_android.domain.usecase;

import android.util.Log;

import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.domain.repository.HistoryRepository;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class HistoryUseCaseImpl extends HistoryUseCase<History> {
    HistoryRepository repository;
    public HistoryUseCaseImpl(HistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getHistories(String userId, DisposableObserver disposable) {
        Log.e(this.getClass().getSimpleName(),"getHistories");
        execute(repository.getHistories(userId),disposable);
    }

    @Override
    public void reportOnHistory(History history) {
        repository.saveToReport(history);
    }
}

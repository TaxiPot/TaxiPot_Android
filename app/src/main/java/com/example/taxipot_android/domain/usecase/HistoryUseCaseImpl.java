package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.domain.repository.HistoryRepository;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class HistoryUseCaseImpl extends HistoryUseCase<List<History>> {
    HistoryRepository repository;
    public HistoryUseCaseImpl(HistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getHistories(String userId, DisposableObserver disposable) {
        execute(repository.getHistories(userId),disposable);
    }
}

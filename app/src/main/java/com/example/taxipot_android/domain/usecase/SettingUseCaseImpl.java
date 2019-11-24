package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.domain.repository.SettingRepository;

import io.reactivex.observers.DisposableSingleObserver;

public class SettingUseCaseImpl extends SettingUseCase {
    private SettingRepository repository;

    public SettingUseCaseImpl(SettingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void changePW(String fromPW, String toPW, DisposableSingleObserver disposable) {
        execute(repository.changePW(fromPW, toPW),disposable);
    }

    @Override
    public void postBug(String content, DisposableSingleObserver disposable) {
        execute(repository.postBug(content),disposable);
    }
}

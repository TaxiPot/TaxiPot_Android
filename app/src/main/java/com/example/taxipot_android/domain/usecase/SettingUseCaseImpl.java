package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.data.validation.SettingValidation;
import com.example.taxipot_android.domain.repository.SettingRepository;

import io.reactivex.observers.DisposableSingleObserver;

public class SettingUseCaseImpl extends SettingUseCase {
    private SettingValidation validation;

    public SettingUseCaseImpl(SettingValidation validation) {
        this.validation = validation;
    }

    @Override
    public void changePW(String fromPW, String toPW, DisposableSingleObserver disposable) {
        execute(validation.changePW(fromPW, toPW),disposable);
    }

    @Override
    public void postBug(String content, DisposableSingleObserver disposable) {
        execute(validation.postBug(content),disposable);
    }
}

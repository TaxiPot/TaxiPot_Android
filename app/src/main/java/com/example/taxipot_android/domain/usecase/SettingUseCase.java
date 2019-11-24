package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.util.UseCase;

import io.reactivex.observers.DisposableSingleObserver;

public abstract class SettingUseCase extends UseCase {
    public abstract void changePW(String fromPW, String toPW, DisposableSingleObserver disposable);

    public abstract void postBug(String content, DisposableSingleObserver disposable);
}

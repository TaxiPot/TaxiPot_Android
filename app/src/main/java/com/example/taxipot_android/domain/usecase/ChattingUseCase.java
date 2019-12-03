package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.util.UseCase;

import io.reactivex.observers.DisposableObserver;

public abstract class ChattingUseCase extends UseCase {
    public abstract void connect(DisposableObserver disposable);

    public abstract void send(String message);

    public abstract void disconnect();

    public abstract void confidenceUp(int seatNum);

    public abstract void confidenceDown(int seatNum);
}

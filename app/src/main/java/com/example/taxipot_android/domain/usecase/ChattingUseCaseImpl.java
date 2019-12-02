package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.domain.repository.ChattingRepository;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.PublishSubject;

public class ChattingUseCaseImpl extends ChattingUseCase {

    ChattingRepository repository;
    PublishSubject subject;

    public ChattingUseCaseImpl(ChattingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void connect(DisposableObserver disposable) {
        subject = repository.connect();
        subject.subscribe(disposable);
    }

    @Override
    public void send(String message) {
        repository.sendMessage(message);
    }

    @Override
    public void disconnect() {
        repository.disconnect();
        subject.onComplete();
    }
}

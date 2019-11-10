package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.util.UseCase;

import io.reactivex.observers.DisposableSingleObserver;

public abstract class SignUpUseCase<T> extends UseCase<T> {
    public abstract void signUp(User user, DisposableSingleObserver disposable);
}

package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.util.UseCase;

import io.reactivex.observers.DisposableSingleObserver;

public abstract class SignInUseCase extends UseCase<User> {

    public abstract void signIn(User user, DisposableSingleObserver disposable);
}

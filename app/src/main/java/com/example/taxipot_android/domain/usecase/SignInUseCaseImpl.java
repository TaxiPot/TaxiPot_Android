package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.repository.SignInRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class SignInUseCaseImpl extends SignInUseCase {

    SignInRepository repository;

    public SignInUseCaseImpl(SignInRepository repository) {
        this.repository = repository;
    }

    @Override
    public void signIn(User user, DisposableSingleObserver disposable) {
        execute(repository.signIn(user),disposable);
    }
}

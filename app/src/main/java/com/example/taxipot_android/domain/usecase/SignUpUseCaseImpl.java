package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.repository.SignUpRepository;

import io.reactivex.observers.DisposableSingleObserver;

public class SignUpUseCaseImpl extends SignUpUseCase<User>{
    SignUpRepository repository;

    public SignUpUseCaseImpl(SignUpRepository repository) {
        this.repository = repository;
    }

    @Override
    public void signUp(User user, DisposableSingleObserver disposable) {
        execute(repository.signup(user),disposable);
    }
}

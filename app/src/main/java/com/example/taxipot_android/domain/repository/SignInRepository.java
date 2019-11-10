package com.example.taxipot_android.domain.repository;

import com.example.taxipot_android.domain.entity.User;

import io.reactivex.Single;

public interface SignInRepository {
    Single<User> signIn(User user);
}

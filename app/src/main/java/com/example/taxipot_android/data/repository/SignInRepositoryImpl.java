package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.repository.SignInRepository;

import io.reactivex.Single;

public class SignInRepositoryImpl implements SignInRepository {
    RemoteAPI api;

    public SignInRepositoryImpl(RemoteAPI api) {
        this.api = api;
    }

    public Single<User> signIn(User user) {
        return api.signIn(user);
    }
}

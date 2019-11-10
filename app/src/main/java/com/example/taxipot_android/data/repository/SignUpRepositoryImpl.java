package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.repository.SignUpRepository;
import com.example.taxipot_android.util.HttpResult;

import io.reactivex.Single;

public class SignUpRepositoryImpl implements SignUpRepository {

    private RemoteAPI api;

    public SignUpRepositoryImpl(RemoteAPI api) {
        this.api = api;
    }

    public Single<User> signup(User user) {
        return api.signUp(user);
    }
}

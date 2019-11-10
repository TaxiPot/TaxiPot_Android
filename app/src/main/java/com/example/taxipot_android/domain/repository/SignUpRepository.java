package com.example.taxipot_android.domain.repository;

import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.util.HttpResult;

import io.reactivex.Single;

public interface SignUpRepository {
    Single<User> signup(User user);
}

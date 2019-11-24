package com.example.taxipot_android.domain.repository;

import com.example.taxipot_android.domain.entity.Bug;
import com.example.taxipot_android.domain.entity.User;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface SettingRepository {
    Single<Bug> postBug(String content);

    Single<User> changePW(String fromPW, String toPW);
}

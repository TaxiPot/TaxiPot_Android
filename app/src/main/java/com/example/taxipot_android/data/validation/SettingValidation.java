package com.example.taxipot_android.data.validation;

import com.example.taxipot_android.domain.entity.Bug;
import com.example.taxipot_android.domain.entity.User;

import io.reactivex.Single;

public interface SettingValidation {
    Single<Bug> postBug(String content);

    Single<User> changePW(String fromPW, String toPW);
}

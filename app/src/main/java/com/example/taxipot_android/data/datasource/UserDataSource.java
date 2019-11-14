package com.example.taxipot_android.data.datasource;

import com.example.taxipot_android.data.api.UserApi;
import com.example.taxipot_android.domain.entity.User;

import io.reactivex.Observable;
import io.reactivex.Single;

public class UserDataSource {
    private UserApi api;
    public UserDataSource(UserApi api){
        this.api = api;
    }

    public Single<User> signIn(User user) {
        return api.requestSignIn(user);
    }

    public Single<User> signUp(User user) {
        return api.requestSignUp(user);
    }

    public Observable<User> changePassword (String id, String fromPW, String toPW) {
        return api.changePassword(id,fromPW,toPW);
    }
}

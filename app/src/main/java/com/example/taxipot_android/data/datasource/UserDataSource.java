package com.example.taxipot_android.data.datasource;

import com.example.taxipot_android.data.api.UserApi;
import com.example.taxipot_android.domain.entity.User;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserDataSource {
    private UserApi api;
    public UserDataSource(UserApi api){
        this.api = api;
    }

    public Single<User> signIn(User user) {
        return api.requestSignIn(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<User> signUp(User user) {
        return api.requestSignUp(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<User> changePassword (String id, String fromPW, String toPW) {
        return api.changePassword(id,fromPW,toPW)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

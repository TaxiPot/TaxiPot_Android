package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.di.application.BaseApplication;
import com.example.taxipot_android.domain.entity.Bug;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.repository.SettingRepository;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class SettingRepositoryImpl implements SettingRepository {
    RemoteAPI api;

    public SettingRepositoryImpl(RemoteAPI api) {
        this.api = api;
    }

    String getUser() {
        return BaseApplication.getUser().getUserId();
    }

    void setUser(User user) {
        BaseApplication.setUser(user);
    }

    public Single<Bug> postBug(String content) {
        Bug bug = new Bug(content, getUser());
        return api.postBug(bug);
    }

    @Override
    public Single<User> changePW(String fromPW, String toPW) {
        return api.changePassWord(getUser(), fromPW, toPW)
                .map(new Function<User, User>() {
                    @Override
                    public User apply(User user) throws Exception {
                        setUser(user);
                        return user;
                    }
                });
    }
}

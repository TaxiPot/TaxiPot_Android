package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.datasource.UserDataSource;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.domain.repository.SignInRepository;

public class SignInRepositoryImpl implements SignInRepository {
    RemoteAPI api;

    public SignInRepositoryImpl(RemoteAPI api) {
        this.api = api;
    }
}

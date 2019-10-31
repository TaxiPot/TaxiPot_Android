package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.domain.repository.SignUpRepository;

public class SignUpRepositoryImpl implements SignUpRepository {

    private RemoteAPI api;

    public SignUpRepositoryImpl(RemoteAPI api) {
        this.api = api;
    }
}

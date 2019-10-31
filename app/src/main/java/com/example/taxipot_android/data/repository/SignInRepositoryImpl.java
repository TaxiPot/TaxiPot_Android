package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.datasource.UserDataSource;
import com.example.taxipot_android.domain.repository.SignInRepository;

public class SignInRepositoryImpl implements SignInRepository {
    UserDataSource dataSource;

    public SignInRepositoryImpl(UserDataSource dataSource) {
        this.dataSource = dataSource;
    }
}

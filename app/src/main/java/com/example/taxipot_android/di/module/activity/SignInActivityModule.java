package com.example.taxipot_android.di.module.activity;

import com.example.taxipot_android.data.datasource.UserDataSource;
import com.example.taxipot_android.data.repository.SignInRepositoryImpl;
import com.example.taxipot_android.domain.repository.SignInRepository;
import com.example.taxipot_android.presenter.viewModelFactory.SignInViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class SignInActivityModule {
    @Provides
    public SignInViewModelFactory provideViewModel(SignInRepository repository) {
        return new SignInViewModelFactory(repository);
    }

    @Provides
    public SignInRepository provideRepository(UserDataSource dataSource) {
        return new SignInRepositoryImpl(dataSource);
    }
}

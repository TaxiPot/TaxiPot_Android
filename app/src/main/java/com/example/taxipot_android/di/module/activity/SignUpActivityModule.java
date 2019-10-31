package com.example.taxipot_android.di.module.activity;

import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.data.remote.RemoteAPIImpl;
import com.example.taxipot_android.data.repository.SignUpRepositoryImpl;
import com.example.taxipot_android.domain.repository.SignUpRepository;
import com.example.taxipot_android.presenter.viewModelFactory.SignUpViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class SignUpActivityModule {

    @Provides
    SignUpViewModelFactory provideViewModelFactory(SignUpRepository repository) {
        return new SignUpViewModelFactory(repository);
    }

    @Provides
    SignUpRepository repository(RemoteAPI api) {
        return new SignUpRepositoryImpl(api);
    }
}

package com.example.taxipot_android.di.module.activity;

import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.data.repository.SignUpRepositoryImpl;
import com.example.taxipot_android.domain.repository.SignUpRepository;
import com.example.taxipot_android.domain.usecase.SignUpUseCase;
import com.example.taxipot_android.domain.usecase.SignUpUseCaseImpl;
import com.example.taxipot_android.presenter.viewModelFactory.SignUpViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class SignUpActivityModule {

    @Provides
    SignUpViewModelFactory provideViewModelFactory(SignUpUseCase useCase) {
        return new SignUpViewModelFactory(useCase);
    }

    @Provides
    SignUpUseCase useCase(SignUpRepository repository) {
        return new SignUpUseCaseImpl(repository);
    }

    @Provides
    SignUpRepository repository(RemoteAPI api) {
        return new SignUpRepositoryImpl(api);
    }
}

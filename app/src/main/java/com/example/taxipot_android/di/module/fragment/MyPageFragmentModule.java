package com.example.taxipot_android.di.module.fragment;


import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.data.repository.SignInRepositoryImpl;
import com.example.taxipot_android.domain.repository.SignInRepository;
import com.example.taxipot_android.domain.usecase.SignInUseCase;
import com.example.taxipot_android.domain.usecase.SignInUseCaseImpl;
import com.example.taxipot_android.presenter.viewModelFactory.MyPageViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MyPageFragmentModule {
    @Provides
    public MyPageViewModelFactory factory(SignInUseCase useCase) {
        return new MyPageViewModelFactory(useCase);
    }

    @Provides
    public SignInUseCase useCase(SignInRepository repository) {
        return new SignInUseCaseImpl(repository);
    }

    @Provides
    public SignInRepository provideRepository(RemoteAPI api) {
        return new SignInRepositoryImpl(api);
    }
}

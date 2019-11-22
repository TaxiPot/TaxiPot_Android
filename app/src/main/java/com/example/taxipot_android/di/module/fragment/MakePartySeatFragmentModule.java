package com.example.taxipot_android.di.module.fragment;

import com.example.taxipot_android.data.cache.TaxiPotCache;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.data.repository.MakePartySeatRepositoryImpl;
import com.example.taxipot_android.data.validation.MakePartySeatValidation;
import com.example.taxipot_android.data.validation.MakePartySeatValidationImpl;
import com.example.taxipot_android.domain.repository.MakePartySeatRepository;
import com.example.taxipot_android.domain.usecase.MakePartySeatUseCase;
import com.example.taxipot_android.domain.usecase.MakePartySeatUseCaseImpl;
import com.example.taxipot_android.presenter.viewModelFactory.MakePartySeatViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class MakePartySeatFragmentModule {
    @Provides
    public MakePartySeatViewModelFactory factory(MakePartySeatUseCase useCase) {
        return new MakePartySeatViewModelFactory(useCase);
    }

    @Provides
    public MakePartySeatUseCase useCase(MakePartySeatValidation validation) {
        return new MakePartySeatUseCaseImpl(validation);
    }

    @Provides
    public MakePartySeatValidation validation(MakePartySeatRepository repository) {
        return new MakePartySeatValidationImpl(repository);
    }

    @Provides
    public MakePartySeatRepository repository(TaxiPotCache cache, RemoteAPI api) {
        return new MakePartySeatRepositoryImpl(cache,api);
    }
}

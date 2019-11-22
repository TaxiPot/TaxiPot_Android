package com.example.taxipot_android.di.module.fragment;

import android.app.Application;

import com.example.taxipot_android.data.cache.TaxiPotCache;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.data.repository.MakePartyRepositoryImpl;
import com.example.taxipot_android.data.validation.MakePartyValidation;
import com.example.taxipot_android.data.validation.MakePartyValidationImpl;
import com.example.taxipot_android.domain.repository.MakePartyRepository;
import com.example.taxipot_android.domain.usecase.MakePartyUseCase;
import com.example.taxipot_android.domain.usecase.MakePartyUseCaseImpl;
import com.example.taxipot_android.presenter.viewModelFactory.MakePartyViewModelFactory;
import com.example.taxipot_android.util.MapPosition;

import dagger.Module;
import dagger.Provides;

@Module
public class MakePartyFragmentModule {
    @Provides
    public MakePartyViewModelFactory factory(MakePartyUseCase useCase) {
        return new MakePartyViewModelFactory(useCase);
    }
    @Provides
    public MakePartyUseCase useCase(MakePartyValidation validation) {
        return new MakePartyUseCaseImpl(validation);
    }
    @Provides
    public MakePartyValidation validation(MakePartyRepository repository) {
        return new MakePartyValidationImpl(repository);
    }

    @Provides
    public MakePartyRepository repository(RemoteAPI api, TaxiPotCache taxiPotCache, MapPosition mapPosition) {
        return new MakePartyRepositoryImpl(api, taxiPotCache, mapPosition);
    }
}

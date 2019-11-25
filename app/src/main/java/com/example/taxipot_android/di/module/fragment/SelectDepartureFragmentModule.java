package com.example.taxipot_android.di.module.fragment;

import com.example.taxipot_android.data.cache.TaxiPotCache;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.data.repository.SelectLocateRepositoryImpl;
import com.example.taxipot_android.domain.repository.SelectLocateRepository;
import com.example.taxipot_android.domain.usecase.SelectLocateUseCase;
import com.example.taxipot_android.domain.usecase.SelectLocateUseCaseImpl;
import com.example.taxipot_android.presenter.viewModelFactory.SelectLocateViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class SelectDepartureFragmentModule {
    @Provides
    public SelectLocateViewModelFactory factory(SelectLocateUseCase useCase) {
        return new SelectLocateViewModelFactory(useCase);
    }

    @Provides
    public SelectLocateUseCase useCase(SelectLocateRepository repository) {
        return new SelectLocateUseCaseImpl(repository);
    }

    @Provides
    public SelectLocateRepository repository(RemoteAPI api, TaxiPotCache cache) {
        return new SelectLocateRepositoryImpl(api,cache);
    }
}

package com.example.taxipot_android.di.module.fragment;

import com.example.taxipot_android.data.cache.TaxiPotCache;
import com.example.taxipot_android.data.repository.ConfirmTaxiPotRepositoryImpl;
import com.example.taxipot_android.domain.repository.ConfirmTaxiPotRepository;
import com.example.taxipot_android.domain.usecase.ConfirmTaxiPotUseCase;
import com.example.taxipot_android.domain.usecase.ConfirmTaxiPotUseCaseImpl;
import com.example.taxipot_android.presenter.viewModelFactory.ConfirmTaxiPotViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ConfirmTaxiPotModule {
    @Provides
    public ConfirmTaxiPotViewModelFactory factory(ConfirmTaxiPotUseCase useCase) {
        return new ConfirmTaxiPotViewModelFactory(useCase);
    }

    @Provides
    public ConfirmTaxiPotUseCase useCase(ConfirmTaxiPotRepository repository) {
        return new ConfirmTaxiPotUseCaseImpl(repository);
    }

    @Provides
    public ConfirmTaxiPotRepository repository(TaxiPotCache cache) {
        return new ConfirmTaxiPotRepositoryImpl(cache);
    }
}

package com.example.taxipot_android.presenter.viewModelFactory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.taxipot_android.domain.usecase.ConfirmTaxiPotUseCase;

public class ConfirmTaxiPotViewModelFactory implements ViewModelProvider.Factory {

    ConfirmTaxiPotUseCase useCase;

    public ConfirmTaxiPotViewModelFactory(ConfirmTaxiPotUseCase useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try{
            return modelClass.getConstructor(ConfirmTaxiPotUseCase.class).newInstance(useCase);
        } catch (Exception e) {
            return null;
        }
    }
}

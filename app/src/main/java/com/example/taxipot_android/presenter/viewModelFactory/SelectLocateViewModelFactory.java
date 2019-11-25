package com.example.taxipot_android.presenter.viewModelFactory;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.taxipot_android.domain.usecase.SelectLocateUseCase;

public class SelectLocateViewModelFactory implements ViewModelProvider.Factory {

    SelectLocateUseCase useCase;

    public SelectLocateViewModelFactory(SelectLocateUseCase useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return modelClass.getConstructor(SelectLocateUseCase.class).newInstance(useCase);
        } catch (Exception e) {
            Log.e(this.getClass().getSimpleName(),e.getMessage());
            return null;
        }
    }
}

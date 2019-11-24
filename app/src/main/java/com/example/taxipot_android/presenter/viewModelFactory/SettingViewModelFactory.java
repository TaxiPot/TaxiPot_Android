package com.example.taxipot_android.presenter.viewModelFactory;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.taxipot_android.domain.usecase.SettingUseCase;

import java.lang.reflect.InvocationTargetException;

public class SettingViewModelFactory implements ViewModelProvider.Factory {

    SettingUseCase useCase;

    public SettingViewModelFactory(SettingUseCase useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try{
            return modelClass.getConstructor(SettingUseCase.class).newInstance(useCase);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            Log.e(this.getClass().getSimpleName(),e.getMessage());
            return null;
        }
    }
}

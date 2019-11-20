package com.example.taxipot_android.presenter.viewModelFactory;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.taxipot_android.domain.usecase.MakePartyUseCase;

import java.lang.reflect.InvocationTargetException;

public class MakePartyViewModelFactory implements ViewModelProvider.Factory {

    private MakePartyUseCase useCase;

    public MakePartyViewModelFactory(MakePartyUseCase useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        T obj = null;
        try {
            obj = modelClass.getConstructor(MakePartyUseCase.class).newInstance(useCase);
        } catch (NoSuchMethodException nsme) {
            Log.e("MakePartyViewModelFactory", "getConstructor");
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            Log.e("MakePartyViewModelFactory", "newInstance");
        }

        return obj;
    }
}

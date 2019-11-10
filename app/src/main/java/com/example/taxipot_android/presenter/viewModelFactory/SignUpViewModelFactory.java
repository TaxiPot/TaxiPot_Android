package com.example.taxipot_android.presenter.viewModelFactory;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.taxipot_android.domain.repository.SignUpRepository;
import com.example.taxipot_android.domain.usecase.SignUpUseCase;

import java.lang.reflect.InvocationTargetException;

public class SignUpViewModelFactory implements ViewModelProvider.Factory {

    private SignUpUseCase useCase;

    public SignUpViewModelFactory(SignUpUseCase useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        T obj = null;
        try {
            obj = modelClass.getConstructor(SignUpUseCase.class).newInstance(useCase);
        } catch (NoSuchMethodException nsme) {
            Log.e("SignUpViewModelFactory", "getConstructor");
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            Log.e("SignUpViewModelFactory", "newInstance");
        }
        return obj;
    }
}

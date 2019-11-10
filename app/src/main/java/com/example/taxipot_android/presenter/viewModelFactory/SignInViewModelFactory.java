package com.example.taxipot_android.presenter.viewModelFactory;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.taxipot_android.data.repository.SignInRepositoryImpl;
import com.example.taxipot_android.domain.repository.SignInRepository;
import com.example.taxipot_android.domain.usecase.SignInUseCase;
import com.example.taxipot_android.presenter.viewModel.SignInViewModel;

import java.lang.reflect.InvocationTargetException;

public class SignInViewModelFactory implements ViewModelProvider.Factory {
    SignInUseCase useCase;

    public SignInViewModelFactory(SignInUseCase useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        T obj = null;
        try {
            obj = modelClass.getConstructor(SignInUseCase.class).newInstance(useCase);
        } catch (NoSuchMethodException nsme) {
            Log.e("SignInViewModelFactory", "getConstructor");
            Log.e("SignInViewModelFactory",nsme.getMessage());
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            Log.e("SignInViewModelFactory", "newInstance");
        }
        return obj;
    }
}

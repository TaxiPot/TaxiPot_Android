package com.example.taxipot_android.presenter.viewModelFactory;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.taxipot_android.data.repository.SignInRepositoryImpl;
import com.example.taxipot_android.domain.repository.SignInRepository;
import com.example.taxipot_android.presenter.viewModel.SignInViewModel;

import java.lang.reflect.InvocationTargetException;

public class SignInViewModelFactory implements ViewModelProvider.Factory {
    SignInRepository repository;

    public SignInViewModelFactory(SignInRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        T obj = null;
        try {
            obj = modelClass.getConstructor(SignInRepository.class).newInstance(repository);
        } catch (NoSuchMethodException nsme) {
            Log.e("SignInViewModelFactory", "getConstructor");
            Log.e("SignInViewModelFactory",nsme.getMessage());
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            Log.e("SignInViewModelFactory", "newInstance");
        }
        return obj;
    }
}

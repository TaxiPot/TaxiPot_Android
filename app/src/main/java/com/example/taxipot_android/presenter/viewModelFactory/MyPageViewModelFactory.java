package com.example.taxipot_android.presenter.viewModelFactory;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.taxipot_android.domain.usecase.SignInUseCase;

import java.lang.reflect.InvocationTargetException;

public class MyPageViewModelFactory implements ViewModelProvider.Factory {
    private SignInUseCase useCase;

    public MyPageViewModelFactory(SignInUseCase useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        T obj = null;
        try {
            obj = modelClass.getConstructor(SignInUseCase.class).newInstance(useCase);
        } catch (NoSuchMethodException nsme) {
            Log.e("MyPageViewModelFactory", "getConstructor");
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            Log.e("MyPageViewModelFactory", "newInstance");
        }
        return obj;
    }
}

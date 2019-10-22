package com.example.taxipot_android.presenter.viewModelFactory;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.InvocationTargetException;

public class MakePartyViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        T obj = null;
        try {
            obj = modelClass.getConstructor().newInstance();
        } catch (NoSuchMethodException nsme) {
            Log.e("MakePartyViewModelFactory", "getConstructor");
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            Log.e("MakePartyViewModelFactory", "newInstance");
        }

        return obj;
    }
}

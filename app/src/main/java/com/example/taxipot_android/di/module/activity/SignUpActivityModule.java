package com.example.taxipot_android.di.module.activity;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.InvocationTargetException;

import dagger.Module;
import dagger.Provides;

@Module
public class SignUpActivityModule {

    @Provides
    ViewModelProvider.Factory provideViewModelFactory() {
        ViewModelProvider.Factory factory = new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                T obj = null;
                try {
                    obj = modelClass.getConstructor().newInstance();
                } catch (NoSuchMethodException nsme) {
                    Log.e("SignUp2ViewModelFactory", "getConstructor");
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    Log.e("SignUp2ViewModelFactory", "newInstance");
                }
                return obj;
            }
        };

        return factory;
    }
}

package com.example.taxipot_android.di.module;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.InvocationTargetException;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelFactoryModule {
    @Provides
    public ViewModelProvider.Factory provideViewModelFactory(){
        return new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                T obj = null;
                try{
                    obj = modelClass.getConstructor().newInstance();
                } catch (NoSuchMethodException e) {
                    Log.e("ViewModelFactory NSM",e.getMessage());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e){
                    Log.e("ViewModelFactory NI", e.getMessage());
                }
                return obj;
            }
        };
    }

    @Provides
    public String provideStringForTest(){
        return "OK";
    }
}
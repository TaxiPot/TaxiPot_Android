package com.example.taxipot_android.presenter.viewModelFactory;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.taxipot_android.domain.usecase.ReportSelSeatUseCase;

import java.lang.reflect.InvocationTargetException;

public class ReportSelSeatViewmodelFactory implements ViewModelProvider.Factory {
    ReportSelSeatUseCase useCase;

    public ReportSelSeatViewmodelFactory(ReportSelSeatUseCase useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        T obj = null;
        try {
            obj = modelClass.getConstructor(ReportSelSeatUseCase.class).newInstance(useCase);
        } catch (NoSuchMethodException nsme) {
            Log.e(this.getClass().getSimpleName(), "getConstructor");
            Log.e(this.getClass().getSimpleName(),nsme.getMessage());
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            Log.e(this.getClass().getSimpleName(), "newInstance");
        }
        return obj;
    }
}

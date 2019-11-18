package com.example.taxipot_android.util;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;

public class BaseViewModel extends ViewModel {
    private MutableLiveData<String> toastString = new MutableLiveData<>();
    private LiveData<String> toast = toastString;
    protected UseCase useCase = new UseCase() {
        @Override
        protected void execute(Observable observable, DisposableObserver disposable) {
            super.execute(observable, disposable);
        }

        @Override
        protected void execute(Single observable, DisposableSingleObserver disposable) {
            super.execute(observable, disposable);
        }

        @Override
        public void dispose() {
            super.dispose();
        }
    };

    protected void setToast(String str) {
        toastString.postValue(str);
    }

    public LiveData<String> getToast() {
        return toast;
    }

    @Override
    public void onCleared() {
        super.onCleared();
        useCase.dispose();
    }
}

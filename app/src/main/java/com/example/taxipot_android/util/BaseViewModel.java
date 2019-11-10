package com.example.taxipot_android.util;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {
    private MutableLiveData<String> toastString = new MutableLiveData<>();
    private LiveData<String> toast = toastString;
    protected UseCase useCase;

    protected void setToast(String str) {
        toastString.postValue(str);
    }

    public LiveData<String> getToast() {
        return toast;
    }

    public void onDestroy() {
        useCase.dispose();
    }
}

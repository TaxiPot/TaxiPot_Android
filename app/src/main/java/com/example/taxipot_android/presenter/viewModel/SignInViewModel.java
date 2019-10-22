package com.example.taxipot_android.presenter.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SignInViewModel extends ViewModel {
    public MutableLiveData<String> userId = new MutableLiveData<>();
    public MutableLiveData<String> userPassword = new MutableLiveData<>();
}

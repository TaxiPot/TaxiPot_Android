package com.example.taxipot_android.presenter.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SignUp2ViewModel extends ViewModel {
    public MutableLiveData<Boolean> canMan = new MutableLiveData(false);
    public MutableLiveData<Boolean> canWoman = new MutableLiveData(false);
}

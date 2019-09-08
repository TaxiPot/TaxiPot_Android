package com.example.taxipot_android.presenter.viewModel;

import android.util.Log;
import android.util.Pair;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SignUp2ViewModel extends ViewModel {
    public MutableLiveData<Boolean> canMan = new MutableLiveData(false);
    public MutableLiveData<Boolean> canWoman = new MutableLiveData(false);
}

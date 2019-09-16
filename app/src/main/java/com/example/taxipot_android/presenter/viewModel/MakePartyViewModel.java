package com.example.taxipot_android.presenter.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MakePartyViewModel {
    public MutableLiveData<Boolean> isMan = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> isWoman = new MutableLiveData<>(false);
    public MutableLiveData<String> ageLimit = new MutableLiveData<>("00");
}
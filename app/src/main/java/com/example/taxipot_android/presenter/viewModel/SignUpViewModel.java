package com.example.taxipot_android.presenter.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SignUpViewModel extends ViewModel {
    public MutableLiveData<Boolean> isMan = new MutableLiveData<>(true);
    public MutableLiveData<String> ageLimit = new MutableLiveData<>("00");
    public MutableLiveData<Boolean> visibility = new MutableLiveData<>(false);
}

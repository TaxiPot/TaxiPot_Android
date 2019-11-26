package com.example.taxipot_android.presenter.viewModel;

import androidx.lifecycle.MutableLiveData;

import com.example.taxipot_android.util.BaseViewModel;

public class SelectLocationViewModel extends BaseViewModel {
    public MutableLiveData<String> addressData = new MutableLiveData<>("");
}

package com.example.taxipot_android.presenter.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyPageViewModel extends ViewModel {
    public MutableLiveData<Integer> trustPoint = new MutableLiveData<>(0);
    public MutableLiveData<Boolean> isMan = new MutableLiveData<>(true);
    public MutableLiveData<Integer> age = new MutableLiveData<>(0);

    public String man = "남자";
    public String woman = "여자";
}

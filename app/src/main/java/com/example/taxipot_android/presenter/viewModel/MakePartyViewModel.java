package com.example.taxipot_android.presenter.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MakePartyViewModel extends ViewModel {
    public MutableLiveData<String> departure = new MutableLiveData<>("출발지를 등록해주세요.");
    public MutableLiveData<String> arrive = new MutableLiveData<>("도착지를 등록해주세요.");
    public MutableLiveData<Boolean> isMan = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> isWoman = new MutableLiveData<>(false);
    public MutableLiveData<String> ageLowLimit = new MutableLiveData<>("00");
    public MutableLiveData<String> ageHighLimit = new MutableLiveData<>("99");
    public MutableLiveData<String> year = new MutableLiveData<>("2019");
    public MutableLiveData<String> month = new MutableLiveData<>("01");
    public MutableLiveData<String> day = new MutableLiveData<>("01");
    public MutableLiveData<String> hour = new MutableLiveData<>("00");
    public MutableLiveData<String> minute = new MutableLiveData<>("00");

    public void init() {
    }
}
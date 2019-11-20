package com.example.taxipot_android.util;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class IntegerRangeObserver implements Observer<String> {
    private int low;
    private int high;
    private MutableLiveData<String> liveData;

    public IntegerRangeObserver(int low, int high, MutableLiveData<String> liveData) {
        this.low = low;
        this.high = high;
        this.liveData = liveData;
    }

    @Override
    public void onChanged(String s) {
        if(liveData.getValue().equals("")) {
            liveData.postValue("");
        } else if(Integer.parseInt(liveData.getValue())<low){
            liveData.postValue(String.valueOf(low));
        } else if(Integer.parseInt(liveData.getValue())>high) {
            liveData.postValue(String.valueOf(high));
        }
    }
}

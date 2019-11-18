package com.example.taxipot_android.util;

import android.util.Log;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class BaseSeatViewModel extends BaseViewModel {
    protected ListLiveData<String> userSeatList = new ListLiveData<>(4);
    public List<MutableLiveData<Boolean>> checkSeat = new ArrayList<>(4);
}

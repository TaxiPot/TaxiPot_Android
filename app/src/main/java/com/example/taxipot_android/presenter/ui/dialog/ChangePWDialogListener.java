package com.example.taxipot_android.presenter.ui.dialog;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

public interface ChangePWDialogListener {
    MutableLiveData<String> getFromPW();
    MutableLiveData<String> getToPW();
    void changePW(View v);
    void dismiss(View v);
}

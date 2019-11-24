package com.example.taxipot_android.presenter.ui.dialog;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

public interface IntroDeveloperDialogListener {
    MutableLiveData<String> getDialogMessege();
    void getMessege(View v);
    void dismiss(View v);
}

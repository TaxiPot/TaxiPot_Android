package com.example.taxipot_android.presenter.ui.dialog;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

public interface BugReportDialogListener {
    MutableLiveData<String> getBugContent();
    void postBug(View v);
    void dismiss(View v);
}

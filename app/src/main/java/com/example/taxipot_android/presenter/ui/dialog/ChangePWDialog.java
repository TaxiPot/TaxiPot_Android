package com.example.taxipot_android.presenter.ui.dialog;

import android.content.Context;

import com.example.taxipot_android.R;

public class ChangePWDialog extends BaseDialog {

    public ChangePWDialog(Context context) {
        super(context, R.layout.dialog_change_pw);
    }

    @Override
    public void clickApply() {
        dismiss();
    }

    @Override
    public void clickCancel() {
        dismiss();
    }
}

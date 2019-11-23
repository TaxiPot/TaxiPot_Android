package com.example.taxipot_android.presenter.ui.dialog;

import android.content.Context;

import com.example.taxipot_android.R;

public class IntroDeveloperDialog extends BaseDialog {

    public IntroDeveloperDialog(Context context) {
        super(context, R.layout.dialog_text_popup);
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

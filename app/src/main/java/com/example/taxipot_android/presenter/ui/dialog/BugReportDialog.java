package com.example.taxipot_android.presenter.ui.dialog;

import android.content.Context;

import com.example.taxipot_android.R;

public class BugReportDialog extends BaseDialog {
    public BugReportDialog(Context context) {
        super(context, R.layout.dialog_report_bug);
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

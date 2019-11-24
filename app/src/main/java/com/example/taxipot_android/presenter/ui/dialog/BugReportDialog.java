package com.example.taxipot_android.presenter.ui.dialog;

import android.content.Context;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.DialogReportBugBinding;

public class BugReportDialog extends BaseDialog<DialogReportBugBinding> {
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

    public void setVM(BugReportDialogListener vm) {
        show();
        binding.setVm(vm);
    }
}

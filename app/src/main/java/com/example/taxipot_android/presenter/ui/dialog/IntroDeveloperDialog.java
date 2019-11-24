package com.example.taxipot_android.presenter.ui.dialog;

import android.content.Context;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.DialogTextPopupBinding;

public class IntroDeveloperDialog extends BaseDialog<DialogTextPopupBinding> {

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

    public void setVM(IntroDeveloperDialogListener vm) {
        show();
        binding.setVm(vm);
    }
}

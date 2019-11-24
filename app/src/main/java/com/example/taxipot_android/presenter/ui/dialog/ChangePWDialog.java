package com.example.taxipot_android.presenter.ui.dialog;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.DialogChangePwBinding;

public class ChangePWDialog extends BaseDialog<DialogChangePwBinding> {

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

    public void setVM(ChangePWDialogListener vm) {
        show();
        binding.setVm(vm);
    }
}

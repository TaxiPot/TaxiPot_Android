package com.example.taxipot_android.presenter.ui.dialog;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatDialog;

import com.example.taxipot_android.util.DialogNavigate;

public abstract class BaseDialog extends AppCompatDialog implements DialogNavigate {

    private int layoutId;

    public BaseDialog(Context context, @LayoutRes int layoutId) {
        super(context);
        this.layoutId = layoutId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        /*WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        getWindow().setAttributes(layoutParams);*/

        setContentView(layoutId);
    }


}

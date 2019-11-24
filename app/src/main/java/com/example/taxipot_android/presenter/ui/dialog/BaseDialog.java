package com.example.taxipot_android.presenter.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.taxipot_android.util.DialogNavigate;

public abstract class BaseDialog<T extends ViewDataBinding> extends AppCompatDialog implements DialogNavigate {

    private int layoutId;
    T binding;

    public BaseDialog(Context context, @LayoutRes int layoutId) {
        super(context);
        this.layoutId = layoutId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()),layoutId,null,false);
        setContentView(binding.getRoot());
    }
}

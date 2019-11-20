package com.example.taxipot_android.util;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.Observer;

public class ToastObserver implements Observer<String> {
    private Context context;

    public ToastObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onChanged(String s) {
        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
    }
}

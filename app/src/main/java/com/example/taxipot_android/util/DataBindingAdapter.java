package com.example.taxipot_android.util;

import android.widget.EditText;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;

public class DataBindingAdapter {
    @BindingAdapter("android:text")
    public static void setText(EditText editText, Integer integer) {
        editText.setText(String.valueOf(integer));
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static Integer getText(EditText editText) {
        String text = editText.getText().toString();
        if(text.equals("")) return 0;
        else return Integer.parseInt(text);
    }
}

package com.example.taxipot_android.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

import com.google.android.material.bottomnavigation.BottomNavigationView;

@BindingMethods({
        @BindingMethod(
                type = BottomNavigationView.class,
                attribute = "app:onNavigationItemSelected",
                method = "setOnNavigationItemSelectedListener"
        )
})
public class BottomNavigationBindingAdapter extends BottomNavigationView{
        OnNavigationItemSelectedListener listener;
        public BottomNavigationBindingAdapter(Context context) {
                this(context,null);
        }
        public BottomNavigationBindingAdapter(Context context, AttributeSet attr) {
                this(context, attr, 0);
        }
        public BottomNavigationBindingAdapter(Context context, AttributeSet attr, int def) {
                super(context,attr,def);
        }
        public interface OnNavigationItemSelectedListener {
                boolean onNavigationItemSelected(@NonNull MenuItem item);
        }
        public void setOnNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener listener) {
                this.listener = listener;
        }
}

package com.example.taxipot_android.util;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.databinding.ViewDataBinding;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxipot_android.presenter.ui.BaseFragment;

public class BaseNavigateFragment<T extends ViewDataBinding> extends BaseFragment<T> implements Navigate {
    int action;

    protected void setAction(@IdRes int action) {
        this.action = action;
    }

    @Override
    public void nextFragment() {
        NavHostFragment.findNavController(this).navigate(action);
    }

    public void navigateFragment(View v) {
        nextFragment();
    }
}

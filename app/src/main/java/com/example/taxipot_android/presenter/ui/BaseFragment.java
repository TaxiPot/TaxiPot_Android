package com.example.taxipot_android.presenter.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.taxipot_android.di.ActivityScope;

import dagger.android.support.DaggerFragment;

@ActivityScope
public class BaseFragment<T extends ViewDataBinding> extends DaggerFragment {
    private int fragmentLayout;
    protected T binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,fragmentLayout,container,false);
        binding.setLifecycleOwner(this);

        return binding.getRoot();
    }

    public void setFragmentLayout(int fragmentLayout) {
        this.fragmentLayout = fragmentLayout;
    }

    protected void showToast(String string) {
        Toast.makeText(this.getContext(), string,Toast.LENGTH_SHORT).show();
    }
}

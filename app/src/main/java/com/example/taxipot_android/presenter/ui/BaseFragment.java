package com.example.taxipot_android.presenter.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import dagger.android.support.DaggerFragment;

public class BaseFragment extends DaggerFragment {
    private int fragmentLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(fragmentLayout,container,false);
    }

    public void setFragmentLayout(int fragmentLayout) {
        this.fragmentLayout = fragmentLayout;
    }
}

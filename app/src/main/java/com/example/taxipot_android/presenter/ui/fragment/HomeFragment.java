package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentHomeBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_home);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
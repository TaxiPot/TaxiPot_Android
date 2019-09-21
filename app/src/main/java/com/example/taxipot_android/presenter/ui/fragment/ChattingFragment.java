package com.example.taxipot_android.presenter.ui.fragment;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentChattingBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;

import org.jetbrains.annotations.NotNull;

public class ChattingFragment extends BaseFragment<FragmentChattingBinding> {

    @NotNull
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_chatting);
        View v = super.onCreateView(inflater, container, savedInstanceState);
        binding.setFragment(this);
        return v;
    }

}

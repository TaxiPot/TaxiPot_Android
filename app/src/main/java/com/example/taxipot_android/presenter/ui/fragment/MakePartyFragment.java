package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentMakePartyBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MakePartyFragment extends BaseFragment<FragmentMakePartyBinding> {

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_make_party);
        View v = super.onCreateView(inflater, container, savedInstanceState);
        return v;
    }
}

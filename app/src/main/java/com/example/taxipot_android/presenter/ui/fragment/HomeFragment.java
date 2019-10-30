package com.example.taxipot_android.presenter.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentHomeBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.ui.activity.FindPartyActivity;
import com.example.taxipot_android.presenter.ui.activity.MakePartyActivity;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_home);
        View inflate = super.onCreateView(inflater, container, savedInstanceState);
        binding.setFragment(this);

        return inflate;
    }

    public void findRoomListener(View v) {
        startActivity(new Intent(getActivity(), FindPartyActivity.class));
    }

    public void newRoomListener(View v) {
        startActivity(new Intent(getActivity(), MakePartyActivity.class));
    }
}
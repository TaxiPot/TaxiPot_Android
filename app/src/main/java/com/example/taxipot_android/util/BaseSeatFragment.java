package com.example.taxipot_android.util;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentSelectSeatBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;

public class BaseSeatFragment extends BaseFragment<FragmentSelectSeatBinding> {
    private int nextActionId;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_select_seat);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void applySeatSelect(View v) {
        NavHostFragment.findNavController(this).navigate(nextActionId);
    }

    protected void setActionId(int nextActionId) {
        this.nextActionId = nextActionId;
    }
}

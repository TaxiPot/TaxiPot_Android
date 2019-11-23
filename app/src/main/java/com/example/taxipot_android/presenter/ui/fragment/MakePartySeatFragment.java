package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.presenter.viewModel.MakePartySeatViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.MakePartySeatViewModelFactory;
import com.example.taxipot_android.util.BaseSeatFragment;
import com.example.taxipot_android.util.ToastObserver;

import javax.inject.Inject;

public class MakePartySeatFragment extends BaseSeatFragment {

    @Inject
    MakePartySeatViewModelFactory factory;
    MakePartySeatViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        binding.setUi(this);
        viewModel = ViewModelProviders.of(this,factory).get(MakePartySeatViewModel.class);
        viewModel.getToast().observe(this, new ToastObserver(getContext()));
        viewModel.setNavigate(this);
        viewModel.getTaxiPot().observe(this, (strings) -> {
            if (strings.size() != 4) return;
            for (int i = 0; i < 4; i++) {
                if (strings.get(i) == null) {
                    checkBoxList.get(i).setEnabled(true);
                } else {
                    checkBoxList.get(i).setEnabled(false);
                }
            }
        });
        setActionId(R.id.action_makePartySeatFragment_to_chattingFragment);
        return v;
    }

    @Override
    public void applySeatSelect(View v) {
        viewModel.joinToTaxiPot(super.checkSeat);
    }

    @Override
    public void nextFragment() {
        getActivity().finish();
    }
}

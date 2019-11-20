package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentMakePartyBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.viewModel.MakePartyViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.MakePartyViewModelFactory;
import com.example.taxipot_android.util.IntegerRangeObserver;
import com.example.taxipot_android.util.Navigate;
import com.example.taxipot_android.util.ToastObserver;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

public class MakePartyFragment extends BaseFragment<FragmentMakePartyBinding> implements Navigate {

    @Inject
    MakePartyViewModelFactory factory;
    MakePartyViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_make_party);
        View v = super.onCreateView(inflater, container, savedInstanceState);
        viewModel = ViewModelProviders.of(this, factory).get(MakePartyViewModel.class);
        binding.setFragment(this);
        binding.setVm(viewModel);

        viewModel.setNavigate(this);
        viewModel.getToast().observe(this, new ToastObserver(getContext()));
        viewModel.month.observe(this, new IntegerRangeObserver(1,12,viewModel.month));
        viewModel.day.observe(this, new IntegerRangeObserver(1,31,viewModel.day));
        viewModel.hour.observe(this, new IntegerRangeObserver(0,23,viewModel.hour));
        viewModel.minute.observe(this, new IntegerRangeObserver(0,59,viewModel.minute));

        return v;
    }

    @Override
    public void nextFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_makePartyFragment_to_makePartySeatFragment);
    }
}

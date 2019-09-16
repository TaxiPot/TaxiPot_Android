package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentHistoryBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.ui.adapter.HistoryAdapter;
import com.example.taxipot_android.presenter.viewModel.HistoryViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.HistoryViewModelFactory;

import javax.inject.Inject;

public class HistoryFragment extends BaseFragment<FragmentHistoryBinding> {
    @Inject
    HistoryViewModelFactory factory;
    HistoryViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_history);
        View v = super.onCreateView(inflater, container, savedInstanceState);
        this.viewModel = ViewModelProviders.of(this,factory).get(HistoryViewModel.class);
        binding.historyRecyclerview.setLayoutManager(new LinearLayoutManager(this.getContext()));
        binding.historyRecyclerview.setAdapter(new HistoryAdapter(viewModel.getTaxipotList()));
        return v;
    }
}

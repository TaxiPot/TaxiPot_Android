package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentHistoryBinding;
import com.example.taxipot_android.di.application.BaseApplication;
import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.ui.adapter.HistoryAdapter;
import com.example.taxipot_android.presenter.viewModel.HistoryViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.HistoryViewModelFactory;

import java.util.ArrayList;
import java.util.List;

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

        HistoryAdapter adapter = new HistoryAdapter(this,new ArrayList<History>(), viewModel);

        binding.historyRecyclerview.setLayoutManager(new LinearLayoutManager(this.getContext()));
        binding.historyRecyclerview.setAdapter(adapter);

        viewModel.getTaxipotList().observe(this, new Observer<List<History>>() {
            @Override
            public void onChanged(List<History> histories) {
                if (histories.size() > 0) {
                    int lastIndex = histories.size() - 1;
                    adapter.replace(histories);
                }
            }
        });

        viewModel.getHistories(BaseApplication.getUser().getUserId());
        viewModel.getToast().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                makeToast(s);
            }
        });
        return v;
    }
}

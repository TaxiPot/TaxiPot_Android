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
import com.example.taxipot_android.databinding.FragmentSelectReportreasonBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.ui.adapter.ReportReasonAdapter;
import com.example.taxipot_android.presenter.viewModel.ReportSelReasonViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.ReportSelReasonViewModelFactory;
import com.example.taxipot_android.util.ReportReasonList;

import java.util.List;

import javax.inject.Inject;

public class ReportSelReasonFragment extends BaseFragment<FragmentSelectReportreasonBinding> {

    @Inject
    ReportSelReasonViewModelFactory factory;
    ReportSelReasonViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_select_reportreason);
        View v = super.onCreateView(inflater, container, savedInstanceState);

        viewModel = ViewModelProviders.of(this,factory).get(ReportSelReasonViewModel.class);
        binding.setVm(viewModel);

        List<String> reasonList = ReportReasonList.getReportReasonList();
        ReportReasonAdapter adapter = new ReportReasonAdapter(reasonList,viewModel);

        binding.reportReasonReasonlistRv.setAdapter(adapter);
        binding.reportReasonReasonlistRv.setLayoutManager(new LinearLayoutManager(this.getContext()));

        viewModel.getToast().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                makeToast(s);
            }
        });
        viewModel.getSelectPosition().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(adapter.uncheckSeat!=null)
                adapter.uncheckSeat.unCheck();
            }
        });

        return v;
    }
}

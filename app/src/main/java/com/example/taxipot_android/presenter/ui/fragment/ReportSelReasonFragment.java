package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentSelectReportreasonBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.ui.adapter.ReportReasonAdapter;
import com.example.taxipot_android.util.ReportReasonList;

import java.util.List;

public class ReportSelReasonFragment extends BaseFragment<FragmentSelectReportreasonBinding> {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_select_reportreason);
        View v = super.onCreateView(inflater, container, savedInstanceState);
        List<String> reasonList = ReportReasonList.getReportReasonList();
        binding.reportReasonReasonlistRv.setAdapter(new ReportReasonAdapter(reasonList));
        binding.reportReasonReasonlistRv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return v;
    }
}

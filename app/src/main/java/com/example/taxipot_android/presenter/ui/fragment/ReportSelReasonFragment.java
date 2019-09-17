package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentSelectReportreasonBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;

public class ReportSelReasonFragment extends BaseFragment<FragmentSelectReportreasonBinding> {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_select_reportreason);
        View v = super.onCreateView(inflater, container, savedInstanceState);
        return v;
    }
}

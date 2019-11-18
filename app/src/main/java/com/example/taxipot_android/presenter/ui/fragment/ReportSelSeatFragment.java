package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.presenter.viewModel.ReportSelSeatViewmodel;
import com.example.taxipot_android.presenter.viewModelFactory.ReportSelSeatViewmodelFactory;
import com.example.taxipot_android.util.BaseSeatFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ReportSelSeatFragment extends BaseSeatFragment {

    @Inject
    ReportSelSeatViewmodelFactory factory;
    ReportSelSeatViewmodel viewmodel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);

        List<CheckBox> checkBoxList = new ArrayList<>();
        checkBoxList.add(binding.seatFirstSeatCb);
        checkBoxList.add(binding.seatSecondSeatCb);
        checkBoxList.add(binding.seatThirdSeatCb);
        checkBoxList.add(binding.seatFourthSeatCb);
        this.checkBoxList = checkBoxList;

        binding.setUi(this);
        binding.setVm(viewmodel);

        setActionId(R.id.action_reportSelSeatFragment_to_reportSelReasonFragment);

        viewmodel = ViewModelProviders.of(this, factory).get(ReportSelSeatViewmodel.class);
        viewmodel.successSaveReport.postValue(false);
        viewmodel.getHistory();
        viewmodel.getUserSeatList().observe(this, (strings) -> {
            if (strings.size() != 4) return;
            for (int i = 0; i < 4; i++) {
                if (strings.get(i) == null) {
                    checkBoxList.get(i).setEnabled(false);
                } else {
                    checkBoxList.get(i).setEnabled(true);
                }
            }
        });
        viewmodel.getToast().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                makeToast(s);
            }
        });
        return v;
    }

    @Override
    public void applySeatSelect(View v) {
        viewmodel.saveReportUser(checkSeat, this);
    }
}

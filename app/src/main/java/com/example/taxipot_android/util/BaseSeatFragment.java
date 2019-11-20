package com.example.taxipot_android.util;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentSelectSeatBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class BaseSeatFragment extends BaseFragment<FragmentSelectSeatBinding> implements Navigate {
    protected Integer checkSeat = -1;
    protected List<CheckBox> checkBoxList = new ArrayList<>();
    private int nextActionId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_select_seat);
        View v = super.onCreateView(inflater, container, savedInstanceState);

        List<CheckBox> checkBoxList = new ArrayList<>();

        checkBoxList.add(binding.seatFirstSeatCb);
        checkBoxList.add(binding.seatSecondSeatCb);
        checkBoxList.add(binding.seatThirdSeatCb);
        checkBoxList.add(binding.seatFourthSeatCb);

        this.checkBoxList = checkBoxList;

        return v;
    }

    @Override
    public void nextFragment() {
        NavHostFragment.findNavController(this).navigate(nextActionId);
    }

    public void applySeatSelect(View v) {
        nextFragment();
    }

    protected void setActionId(int nextActionId) {
        this.nextActionId = nextActionId;
    }

    public void clickSeat(View v) {
        if (checkSeat != -1) checkBoxList.get(checkSeat).setChecked(false);
        int num = checkBoxList.indexOf(v);
        if (checkSeat == num) {
            checkSeat = -1;
        } else {
            checkSeat = num;
        }
        Log.e(this.getClass().getSimpleName(), checkSeat + "");
    }
}

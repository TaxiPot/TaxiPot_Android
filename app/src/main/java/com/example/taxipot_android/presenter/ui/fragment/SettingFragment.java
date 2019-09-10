package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentSettingBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.ui.adapter.SettingAdapter;

import java.util.ArrayList;
import java.util.List;

public class SettingFragment extends BaseFragment<FragmentSettingBinding> {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_setting);
        View v = super.onCreateView(inflater, container, savedInstanceState);
        binding.settingRecyclerview.setAdapter(new SettingAdapter(getSettingListData()));
        binding.settingRecyclerview.setLayoutManager(new LinearLayoutManager(container.getContext()));
        return v;
    }

    private List<Object> getSettingListData() {
        ArrayList<Object> array = new ArrayList();
        array.add("계정 설정");
        array.add("버그 신고");
        array.add("개발자 소개");
        return array;
    }
}

package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentSettingBinding;
import com.example.taxipot_android.domain.entity.SettingContent;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.ui.adapter.SettingAdapter;
import com.example.taxipot_android.presenter.ui.dialog.BugReportDialog;
import com.example.taxipot_android.presenter.ui.dialog.ChangePWDialog;
import com.example.taxipot_android.presenter.ui.dialog.IntroDeveloperDialog;
import com.example.taxipot_android.presenter.viewModel.SettingViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.SettingViewModelFactory;
import com.example.taxipot_android.util.ToastObserver;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class SettingFragment extends BaseFragment<FragmentSettingBinding> {

    @Inject
    SettingViewModelFactory factory;
    SettingViewModel viewModel;

    ChangePWDialog changePWDialog;
    BugReportDialog bugReportDialog;
    IntroDeveloperDialog introDeveloperDialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_setting);
        View v = super.onCreateView(inflater, container, savedInstanceState);

        viewModel = ViewModelProviders.of(this,factory).get(SettingViewModel.class);
        viewModel.getToast().observe(this, new ToastObserver(getContext()));

        changePWDialog = new ChangePWDialog(getContext());
        bugReportDialog = new BugReportDialog(getContext());
        introDeveloperDialog = new IntroDeveloperDialog(getContext());

        binding.settingRecyclerview.setAdapter(new SettingAdapter(getSettingListData()));
        binding.settingRecyclerview.setLayoutManager(new LinearLayoutManager(container.getContext()));

        return v;
    }

    private List<Object> getSettingListData() {
        ArrayList<Object> array = new ArrayList();
        array.add("계정 설정");
        array.add(new SettingContent("비밀번호 확인", "기존 비밀번호를 변경합니다", new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                changePWDialog.setVM(viewModel);
                viewModel.setNavigate(changePWDialog);
            }
        }));
        array.add(new SettingContent("비밀번호 변경", "대신 사용할 비밀번호로 변경합니다", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePWDialog.setVM(viewModel);
                viewModel.setNavigate(changePWDialog);
            }
        }
        ));
        array.add("버그 신고");
        array.add(new SettingContent("버그 신고하기", "개발자에게 큰 도움이 됩니다", new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bugReportDialog.setVM(viewModel);
                viewModel.setNavigate(bugReportDialog);
            }
        }));
        array.add("개발자 소개");
        array.add(new SettingContent("개발자 보기", "택시팟을 개발한 개발진들입니다", new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                introDeveloperDialog.setVM(viewModel);
                viewModel.setNavigate(introDeveloperDialog);
            }
        }));
        return array;
    }


}

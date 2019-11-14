package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentSettingBinding;
import com.example.taxipot_android.domain.entity.SettingContent;
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
        array.add(new SettingContent("비밀번호 확인", "기존 비밀번호를 변경합니다", new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                makeToast("비밀번호 확인");
            }
        }));
        array.add(new SettingContent("비밀번호 변경", "대신 사용할 비밀번호로 변경합니다", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeToast("비밀번호 변경");
            }
        }
        ));
        array.add("버그 신고");
        array.add(new SettingContent("버그 신고하기", "개발자에게 큰 도움이 됩니다", new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        }));
        array.add("개발자 소개");
        array.add(new SettingContent("개발자 보기", "택시팟을 개발한 개발진들입니다", new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        }));
        return array;
    }


}

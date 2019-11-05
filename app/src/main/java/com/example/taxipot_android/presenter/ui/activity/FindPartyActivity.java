package com.example.taxipot_android.presenter.ui.activity;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivityFindPartyBinding;
import com.example.taxipot_android.presenter.ui.BaseActivity;

public class FindPartyActivity extends BaseActivity {

    ActivityFindPartyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_find_party);
        binding.setActivity(this);
    }

}

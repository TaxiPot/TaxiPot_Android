package com.example.taxipot_android.presenter.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivityMakePartyBinding;
import com.example.taxipot_android.presenter.ui.BaseActivity;

public class MakePartyActivity extends BaseActivity {

    ActivityMakePartyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_make_party);
        binding.setActivity(this);
    }
}

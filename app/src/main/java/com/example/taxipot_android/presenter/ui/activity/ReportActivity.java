package com.example.taxipot_android.presenter.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivityReportBinding;
import com.example.taxipot_android.presenter.ui.BaseActivity;
import com.example.taxipot_android.presenter.ui.fragment.ReportSelSeatFragment;

public class ReportActivity extends BaseActivity {

    ActivityReportBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_report);
    }
    @Override
    protected void showToast() {

    }
}

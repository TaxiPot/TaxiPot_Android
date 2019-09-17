package com.example.taxipot_android.presenter.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivityMakePartyBinding;
import com.example.taxipot_android.presenter.viewModel.MakePartyViewModel;

public class MakePartyActivity extends AppCompatActivity {

    ActivityMakePartyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_make_party);
        binding.setActivity(this);
    }

//    private void liveDataObserve() {
//        viewModel.isMan.observe(this, new Observer<Boolean>() {
//            @Override
//            public void onChanged(Boolean aBoolean) {
//                if(aBoolean) {
//                    changeTextColorRadioButton(binding.signup2GenderIsManRb, binding.signup2GenderIsWomanRb);
//                } else {
//                    changeTextColorRadioButton(binding.signup2GenderIsWomanRb, binding.signup2GenderIsManRb);
//                }
//            }
//        });
//        viewModel.ageLimit.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                if(Integer.parseInt(s) > 99) {
//                    viewModel.ageLimit.postValue("99");
//                } else if(Integer.parseInt(s) < 0){
//                    viewModel.ageLimit.postValue("00");
//                }
//            }
//        });
//    }
}

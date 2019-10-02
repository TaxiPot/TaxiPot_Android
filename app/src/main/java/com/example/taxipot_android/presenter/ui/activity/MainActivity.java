package com.example.taxipot_android.presenter.ui.activity;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivityMainBinding;
import com.example.taxipot_android.presenter.ui.BaseActivity;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class MainActivity extends BaseActivity {

    private Subject<Long> backButtonSubject = BehaviorSubject.createDefault(0L);
    // 더블클릭으로 앱 종료.
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.main_fragment_space_fragment);
        if(fragment instanceof NavHostFragment) {
            Log.i("fragment", "instanceofNavHost");
            NavigationUI.setupWithNavController(binding.mainBottomnavigation,((NavHostFragment) fragment).getNavController());
        }

    }
}

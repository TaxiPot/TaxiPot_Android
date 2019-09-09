package com.example.taxipot_android.util;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.example.taxipot_android.R;
import com.example.taxipot_android.presenter.ui.fragment.HistoryFragment;
import com.example.taxipot_android.presenter.ui.fragment.HomeFragment;
import com.example.taxipot_android.presenter.ui.fragment.MyPageFragment;
import com.example.taxipot_android.presenter.ui.fragment.SettingFragment;

public class BottomNavigationHandler {
    private int container = R.id.main_fragment_space_layout;
    private FragmentManager manager;

    private HomeFragment homeFragment = new HomeFragment();
    private HistoryFragment historyFragment = new HistoryFragment();
    private MyPageFragment myPageFragment = new MyPageFragment();
    private SettingFragment settingFragment = new SettingFragment();

    public BottomNavigationHandler(FragmentManager manager) {
        this.manager = manager;
        manager.beginTransaction().replace(container, homeFragment).commitAllowingStateLoss();
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_home_menu: {
                manager.beginTransaction().replace(container, homeFragment).commitAllowingStateLoss();
                break;
            }
            case R.id.main_history_menu: {
                manager.beginTransaction().replace(container, historyFragment).commitAllowingStateLoss();
                break;
            }
            case R.id.main_mypage_menu: {
                manager.beginTransaction().replace(container, myPageFragment).commitAllowingStateLoss();
                break;
            }
            case R.id.main_setting_menu: {
                manager.beginTransaction().replace(container, settingFragment).commitAllowingStateLoss();
                break;
            }
        }
        return true;
    }

}

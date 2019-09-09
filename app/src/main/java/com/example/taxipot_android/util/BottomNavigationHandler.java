package com.example.taxipot_android.util;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.example.taxipot_android.R;
import com.example.taxipot_android.presenter.ui.fragment.MainHomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationHandler {
    int container = R.id.main_fragment_space_layout;
    FragmentManager manager;
    MainHomeFragment mainHomeFragment = new MainHomeFragment();
    public BottomNavigationHandler(FragmentManager manager) {
        this.manager = manager;
        manager.beginTransaction().add(container,mainHomeFragment).commit();
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_home_menu: {
                break;
            }
            case R.id.main_history_menu: {
                break;
            }
            case R.id.main_mypage_menu: {
                break;
            }
            case R.id.main_setting_menu: {
                break;
            }
        }
        return true;
    }

}

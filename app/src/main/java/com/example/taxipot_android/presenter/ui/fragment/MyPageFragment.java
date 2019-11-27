package com.example.taxipot_android.presenter.ui.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentMypageBinding;
import com.example.taxipot_android.di.application.BaseApplication;
import com.example.taxipot_android.di.module.ApiModule;
import com.example.taxipot_android.di.module.LocalModule;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.ui.activity.SelectLocationActivity;
import com.example.taxipot_android.presenter.viewModel.MyPageViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.MyPageViewModelFactory;
import com.example.taxipot_android.util.MapPosition;

import java.io.IOException;

import javax.inject.Inject;

public class MyPageFragment extends BaseFragment<FragmentMypageBinding> {

    MyPageViewModel viewModel;
    @Inject
    MyPageViewModelFactory factory;
    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    MapPosition mapPosition;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_mypage);
        View v = super.onCreateView(inflater, container, savedInstanceState);
        viewModel = ViewModelProviders.of(this, factory).get(MyPageViewModel.class);
        binding.setFragment(this);
        binding.setVm(viewModel);

        try {
            setBasicsAddress();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setUserDataInUI();
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel.refreshUserData(BaseApplication.getUser());
    }

    public void setBasicsAddress() throws IOException {
        double basicsDepartLatitude = Double.parseDouble(sharedPreferences.getString("basics_depart_latitude", "-1"));
        double basicsDepartLongitude = Double.parseDouble(sharedPreferences.getString("basics_depart_longitude", "-1"));
        double basicsArriveLatitude = Double.parseDouble(sharedPreferences.getString("basics_arrive_latitude", "-1"));
        double basicsArriveLongitude = Double.parseDouble(sharedPreferences.getString("basics_arrive_longitude", "-1"));

        if (basicsDepartLatitude != -1 && basicsDepartLongitude != -1) {
            Address basicsDepartAddress = mapPosition.coordinateToLocate(basicsDepartLatitude, basicsDepartLongitude);
            String basicsArriveAddressData = mapPosition.getLocateFromAddress(basicsDepartAddress);

            viewModel.basicsDepart.setValue(basicsArriveAddressData);
        }

        if (basicsArriveLatitude != -1 && basicsArriveLongitude != -1) {
            Address basicsArriveAddress = mapPosition.coordinateToLocate(basicsArriveLatitude, basicsArriveLongitude);
            String basicsArriveAddressData = mapPosition.getLocateFromAddress(basicsArriveAddress);

            viewModel.basicsArrive.setValue(basicsArriveAddressData);
        }
    }

    public void changeBasicsDepartLocation() {
        Intent intent = new Intent(getActivity(), SelectLocationActivity.class);
        intent.putExtra("map_value", "basics_depart");
        startActivity(intent);
    }

    public void changeBasicsArriveLocation() {
        Intent intent = new Intent(getActivity(), SelectLocationActivity.class);
        intent.putExtra("map_value", "basics_arrive");
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setUserDataInUI() {
        viewModel.isMan.setValue(BaseApplication.getUser().getIsMan());
        viewModel.trustPoint.setValue(BaseApplication.getUser().getTrustPoint());
        viewModel.age.setValue(BaseApplication.getUser().getAge());
    }
}

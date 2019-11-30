package com.example.taxipot_android.presenter.ui.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentMakePartyBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.ui.activity.SelectLocationActivity;
import com.example.taxipot_android.presenter.viewModel.MakePartyViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.MakePartyViewModelFactory;
import com.example.taxipot_android.util.IntegerRangeObserver;
import com.example.taxipot_android.util.MapPosition;
import com.example.taxipot_android.util.Navigate;
import com.example.taxipot_android.util.ToastObserver;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

import javax.inject.Inject;

public class MakePartyFragment extends BaseFragment<FragmentMakePartyBinding> implements Navigate {

    @Inject
    SharedPreferences preferences;
    @Inject
    MapPosition mapPosition;
    @Inject
    MakePartyViewModelFactory factory;
    MakePartyViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_make_party);
        View v = super.onCreateView(inflater, container, savedInstanceState);
        viewModel = ViewModelProviders.of(this, factory).get(MakePartyViewModel.class);
        binding.setFragment(this);
        binding.setVm(viewModel);

        viewModel.setNavigate(this);
        viewModel.getToast().observe(this, new ToastObserver(getContext()));
        viewModel.month.observe(this, new IntegerRangeObserver(1, 12, viewModel.month));
        viewModel.day.observe(this, new IntegerRangeObserver(1, 31, viewModel.day));
        viewModel.hour.observe(this, new IntegerRangeObserver(0, 23, viewModel.hour));
        viewModel.minute.observe(this, new IntegerRangeObserver(0, 59, viewModel.minute));

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        try {
            getSelectData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeSelectPreferenceData();
        // 프래그먼트 처음 접속시 초기화한다.
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        removeSelectPreferenceData();
        // 프래그먼트가 destroy 되는 경우 초기화.
    }

    private void removeSelectPreferenceData() {
        SharedPreferences.Editor editor = preferences.edit();

        editor.remove("select_depart_latitude");
        editor.remove("select_depart_longitude");
        editor.remove("select_arrive_latitude");
        editor.remove("select_arrive_longitude");

        editor.apply();
        Log.d("remove", "remove");
    }

    public void selectDepartLocation() {
        Intent intent = new Intent(getActivity(), SelectLocationActivity.class);
        intent.putExtra("map_value", "select_depart");
        startActivity(intent);
    }

    public void selectArriveLocation() {
        Intent intent = new Intent(getActivity(), SelectLocationActivity.class);
        intent.putExtra("map_value", "select_arrive");
        startActivity(intent);
    }

    private void getSelectData() throws IOException {
        double selectDepartLatitude = Double.parseDouble(preferences.getString("select_depart_latitude", "-1"));
        double selectDepartLongitude = Double.parseDouble(preferences.getString("select_depart_longitude", "-1"));
        double selectArriveLatitude = Double.parseDouble(preferences.getString("select_arrive_latitude", "-1"));
        double selectArriveLongitude = Double.parseDouble(preferences.getString("select_arrive_longitude", "-1"));

        if (selectDepartLatitude != -1 && selectArriveLongitude != -1) {
            Address selectDepartAddress = mapPosition.coordinateToLocate(selectDepartLatitude, selectArriveLongitude);
            String selectArriveAddressData = mapPosition.getLocateFromAddress(selectDepartAddress);

            viewModel.departure.postValue(selectArriveAddressData);
        } else {
            getBasicsDepartData();
        }

        if (selectArriveLatitude != -1 && selectArriveLongitude != -1) {
            Address basicsArriveAddress = mapPosition.coordinateToLocate(selectArriveLatitude, selectArriveLongitude);
            String basicsArriveAddressData = mapPosition.getLocateFromAddress(basicsArriveAddress);

            viewModel.arrive.postValue(basicsArriveAddressData);
        } else {
            getBasicsArriveData();
        }
    }

    private void getBasicsDepartData() throws IOException {
        double basicsDepartLatitude = Double.parseDouble(preferences.getString("basics_depart_latitude", "-1"));
        double basicsDepartLongitude = Double.parseDouble(preferences.getString("basics_depart_longitude", "-1"));

        if (basicsDepartLatitude != -1 && basicsDepartLongitude != -1) {
            Address basicsDepartAddress = mapPosition.coordinateToLocate(basicsDepartLatitude, basicsDepartLongitude);
            String basicsArriveAddressData = mapPosition.getLocateFromAddress(basicsDepartAddress);

            viewModel.departure.postValue(basicsArriveAddressData);
        }
    }

    private void getBasicsArriveData() throws IOException {
        double basicsArriveLatitude = Double.parseDouble(preferences.getString("basics_arrive_latitude", "-1"));
        double basicsArriveLongitude = Double.parseDouble(preferences.getString("basics_arrive_longitude", "-1"));

        if (basicsArriveLatitude != -1 && basicsArriveLongitude != -1) {
            Address basicsArriveAddress = mapPosition.coordinateToLocate(basicsArriveLatitude, basicsArriveLongitude);
            String basicsArriveAddressData = mapPosition.getLocateFromAddress(basicsArriveAddress);

            viewModel.arrive.postValue(basicsArriveAddressData);
        }
    }

    @Override
    public void nextFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_makePartyFragment_to_makePartySeatFragment);
    }
}

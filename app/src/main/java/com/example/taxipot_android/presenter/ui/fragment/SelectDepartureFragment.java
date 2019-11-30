package com.example.taxipot_android.presenter.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentSelectDepartureBinding;
import com.example.taxipot_android.presenter.viewModel.SelectLocateViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.SelectLocateViewModelFactory;
import com.example.taxipot_android.util.BaseNavigateFragment;
import com.example.taxipot_android.util.MapPosition;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tedpark.tedpermission.rx2.TedRx2Permission;

import java.io.IOException;

import javax.inject.Inject;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static com.google.android.gms.maps.GoogleMap.OnMapClickListener;

public class SelectDepartureFragment extends BaseNavigateFragment<FragmentSelectDepartureBinding>
        implements OnMapReadyCallback, OnMapClickListener {

    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    SelectLocateViewModelFactory factory;
    SelectLocateViewModel viewModel;

    GoogleMap googleMap;
    MapView mapView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_select_departure);
        View v = super.onCreateView(inflater, container, savedInstanceState);

        setAction(R.id.action_selectDepartureFragment_to_selectArriveFragment);
        viewModel = ViewModelProviders.of(requireActivity(), factory).get(SelectLocateViewModel.class);

        binding.setFragment(this);
        binding.setVm(viewModel);

        getLocationPermission();

        mapView = binding.mapviewDeparture;
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        return v;
    }

    // TedPermission RxJava2를 통한 권한 요청
    @SuppressLint("CheckResult")
    private void getLocationPermission() {
        TedRx2Permission.with(getActivity())
                .setRationaleTitle("권한 요청")
                .setRationaleMessage("위치 권한이 필요합니다. 승인하시겠습니까?")
                .setPermissions(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION)
                .request()
                .subscribe(tedPermissionResult -> {
                    if (tedPermissionResult.isGranted()) {
                        makeToast("위치 권한 요청 성공");
                        mapView.getMapAsync(this);
                    } else {
                        makeToast("위치 권한을 허용해주세요.");
                        getActivity().finish();
                    }
                }, throwable -> {
                });
    }

    // 맵 처음 나올 때 실행 (getMapAsync(this) 를 통해서! )
    // 일부 코드분할 필요
    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        LatLng myLocation = getMyLocation();
        MapPosition mapPosition = new MapPosition(getActivity());
        String myLocationAddressData;

        // 경도 위도를 주소로 변경하는 로직, MapPosition 선언한것을 통해서 이용함
        try {
            Address myLocationAddress = mapPosition.coordinateToLocate(myLocation.latitude, myLocation.longitude);
            myLocationAddressData = mapPosition.getLocateFromAddress(myLocationAddress);
            Log.d("myLocationAddressData", myLocationAddressData);
        } catch (IOException e) {
            myLocationAddressData = "위치 정보를 찾을 수 없습니다.";
            e.printStackTrace();
        }

        // 현재 내 위치 위경도로 핀을 찍어줌
        MarkerOptions myLocationMarker = new MarkerOptions()
                .position(myLocation)
                .title(myLocationAddressData);

        viewModel.getDepartLatitude().postValue(myLocation.latitude);
        viewModel.getDepartLongitude().postValue(myLocation.longitude);
        viewModel.getDepart().postValue(myLocationAddressData);

        googleMap.addMarker(myLocationMarker);
        googleMap.setMyLocationEnabled(true);
        googleMap.setOnMapClickListener(this);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(13));
    }

    // 내 위치 데이터 LatLng로 return! 합니다
    // MissingPermssion은 이미 권한 확인했는데도 오류 발생하고 있어서 SuppressLint로 무시
    @SuppressLint("MissingPermission")
    private LatLng getMyLocation() {
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));

        double basicsDepartLatitude = Double.parseDouble(sharedPreferences.getString("basics_depart_latitude", "-1"));
        double basicsDepartLongitude = Double.parseDouble(sharedPreferences.getString("basics_depart_longitude", "-1"));

        if (basicsDepartLatitude == -1 || basicsDepartLongitude == -1) {
            return new LatLng(37.5, 127);
        }

        return new LatLng(basicsDepartLatitude, basicsDepartLongitude);
    }

    // 맵 클릭시 핀 찍는 로직들
    // MarkerOptions 분리하면 좋을듯함.
    @Override
    public void onMapClick(LatLng latLng) {
        MapPosition mapPosition = new MapPosition(getActivity());
        String locationAddressData = "";

        try {
            Address myLocationAddress = mapPosition.coordinateToLocate(latLng.latitude, latLng.longitude);
            locationAddressData = mapPosition.getLocateFromAddress(myLocationAddress);
        } catch (IOException e) {
            locationAddressData = "위치 정보를 찾을 수 없습니다.";
            e.printStackTrace();
        }

        viewModel.getDepartLatitude().postValue(latLng.latitude);
        viewModel.getDepartLongitude().postValue(latLng.longitude);
        viewModel.getDepart().postValue(locationAddressData);

        MarkerOptions clickLocationMarker = new MarkerOptions()
                .position(latLng)
                .title(locationAddressData);

        googleMap.clear();
        googleMap.addMarker(clickLocationMarker);
    }


}

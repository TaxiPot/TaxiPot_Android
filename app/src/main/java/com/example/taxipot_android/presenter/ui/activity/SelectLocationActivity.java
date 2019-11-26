package com.example.taxipot_android.presenter.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivitySelectLocationBinding;
import com.example.taxipot_android.di.module.LocalModule;
import com.example.taxipot_android.presenter.ui.BaseActivity;
import com.example.taxipot_android.presenter.viewModel.SelectLocationViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.SelectLocationViewModelFactory;
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
import static com.google.android.gms.maps.GoogleMap.*;

public class SelectLocationActivity extends BaseActivity
        implements OnMapReadyCallback, OnMapClickListener {

    ActivitySelectLocationBinding binding;
    SelectLocationViewModel viewModel;
    @Inject
    SelectLocationViewModelFactory factory;

    @Inject
    SharedPreferences sharedPreferences;

    MapView mapView;
    GoogleMap googleMap;

    String mapValue;
    LatLng pinLatLng = new LatLng(-1, -1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, factory).get(SelectLocationViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_location);
        binding.setVm(viewModel);
        binding.setLifecycleOwner(this);

        Log.d("viewModel", viewModel == null ? "null" : "not null");

        getLocationPermission();

        mapValue = getIntent().getStringExtra("map_value");

        mapView = (MapView) findViewById(R.id.mapview_select_location);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        LatLng myLocation = getMyLocation();

        googleMap.setMyLocationEnabled(true);
        googleMap.setOnMapClickListener(this);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(13));
    }

    @SuppressLint("CheckResult")
    private void getLocationPermission() {
        TedRx2Permission.with(this)
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
                        finish();
                    }
                }, throwable -> {
                });
    }

    @Override
    public void onMapClick(LatLng latLng) {
        MapPosition mapPosition = new MapPosition(this);
        String locationAddressData = "";

        try {
            Address myLocationAddress = mapPosition.coordinateToLocate(latLng.latitude, latLng.longitude);
            locationAddressData = mapPosition.getLocateFromAddress(myLocationAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MarkerOptions clickLocationMarker = new MarkerOptions()
                .position(latLng)
                .title(locationAddressData);

        viewModel.addressData.setValue(locationAddressData);

        googleMap.clear();
        googleMap.addMarker(clickLocationMarker);

        pinLatLng = latLng;
    }

    public void returnLocationData(View v) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Log.d("click", "yes");

        if (pinLatLng.latitude != -1 && pinLatLng.longitude != -1) {
            editor.putString(mapValue + "_latitude", String.valueOf(pinLatLng.latitude));
            editor.putString(mapValue + "_longitude", String.valueOf(pinLatLng.longitude));
            editor.apply();
            Log.d("pinLatLng-save", pinLatLng.toString());
            finish();
        } else {
            Log.d("pinLatLng-save", pinLatLng.toString());
            Toast.makeText(this, "위치를 선택하세요.", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("MissingPermission")
    private LatLng getMyLocation() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        return new LatLng(location.getLatitude(), location.getLongitude());
    }

    @Override
    protected void showToast() {

    }
}

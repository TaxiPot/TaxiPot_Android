package com.example.taxipot_android.presenter.ui.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ActivitySelectLocationBinding;
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
import static com.google.android.gms.maps.GoogleMap.OnMapClickListener;

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
        binding.setLifecycleOwner(this);
        binding.setActivity(this);
        binding.setVm(viewModel);

        Log.d("viewModel", viewModel == null ? "null" : "not null");

        getLocationPermission();

        mapValue = getIntent().getStringExtra("map_value");

        mapView = (MapView) findViewById(R.id.mapview_select_location);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
    }

    public void returnLocationData(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (pinLatLng.latitude != -1 && pinLatLng.longitude != -1) {
            editor.putString(mapValue + "_latitude", String.valueOf(pinLatLng.latitude));
            editor.putString(mapValue + "_longitude", String.valueOf(pinLatLng.longitude));
            editor.apply();
            finish();
        } else {
            Toast.makeText(this, "위치를 선택하세요.", Toast.LENGTH_SHORT).show();
        }
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

        Address myLocationAddress;
        try {
            myLocationAddress = mapPosition.coordinateToLocate(latLng.latitude, latLng.longitude);
            locationAddressData = mapPosition.getLocateFromAddress(myLocationAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MarkerOptions clickLocationMarker = new MarkerOptions()
                .position(latLng)
                .title(locationAddressData);

        viewModel.addressData.postValue(locationAddressData);

        googleMap.clear();
        googleMap.addMarker(clickLocationMarker);

        pinLatLng = latLng;
    }

    private LatLng getMyLocation() {
        LocationManager locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        @SuppressLint("MissingPermission")
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if(location!=null)
        return new LatLng(location.getLatitude(), location.getLongitude());
        return new LatLng(37.5,127);
    }

    @Override
    protected void showToast() {

    }
}

package com.example.taxipot_android.presenter.ui.fragment;

import android.Manifest;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentSelectDepartureBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tedpark.tedpermission.rx2.TedRx2Permission;

public class SelectDepartureFragment extends BaseFragment<FragmentSelectDepartureBinding> implements OnMapReadyCallback {

    MapView mapView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_select_departure);
        View v = super.onCreateView(inflater, container, savedInstanceState);
        binding.setFragment(this);

        getLocationPermission();
        mapView = (MapView) v.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);

        return v;
    }

    public void getLocationPermission() {
        TedRx2Permission.with(getActivity())
                .setRationaleTitle("권한 요청")
                .setRationaleMessage("위치 권한이 필요합니다. 승인하시겠습니까?")
                .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
                .request()
                .subscribe(tedPermissionResult -> {
                    if (tedPermissionResult.isGranted()) {
                        makeToast("위치 권한 요청 성공");
                    } else {
                        makeToast("위치 권한 요청 실패, " + tedPermissionResult.getDeniedPermissions().toString());
                    }
                }, throwable -> {
                });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng SEOUL = new LatLng(37.56, 126.97);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("수도");

        googleMap.addMarker(markerOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(13));
    }
}

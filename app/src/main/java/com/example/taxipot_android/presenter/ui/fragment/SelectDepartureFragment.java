package com.example.taxipot_android.presenter.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
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

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentSelectDepartureBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.util.MapPosition;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tedpark.tedpermission.rx2.TedRx2Permission;

import java.io.IOException;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static com.google.android.gms.maps.GoogleMap.*;

public class SelectDepartureFragment extends BaseFragment<FragmentSelectDepartureBinding>
        implements OnMapReadyCallback, OnMapClickListener {

    GoogleMap googleMap;
    MapView mapView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_select_departure);
        View v = super.onCreateView(inflater, container, savedInstanceState);
        binding.setFragment(this);

        getLocationPermission();

        mapView = (MapView) v.findViewById(R.id.mapview_departure);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        return v;
    }


    // 맵 처음 나올 때 실행 (getMapAsync(this) 를 통해서! )
    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        LatLng myLocation = getMyLocation();
        MapPosition mapPosition = new MapPosition(getActivity());
        String myLocationAddressData = "";

        // 경도 위도를 주소로 변경하는 로직, MapPosition 선언한것을 통해서 이용함
        try {
            Address myLocationAddress = mapPosition.coordinateToLocate(myLocation.latitude, myLocation.longitude);
            myLocationAddressData = mapPosition.getLocateFromAddress(myLocationAddress);
            Log.d("myLocationAddressData", myLocationAddressData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 현재 내 위치 위경도로 핀을 찍어줌
        MarkerOptions myLocationMarker = new MarkerOptions()
                .position(myLocation)
                .title(myLocationAddressData);

        // TODO : 뷰모델 완성시 이 부분에서 EditText에 현 위치 주소를 적는다
        // MapPosition 싱글톤으로 해도 좋을듯 또한 시, 도가 있어야 할 듯 함 구분하기 힘듬.
        // 같은 동이나 구 등이 존재하는 경우가 있어 중복되는 결과가 나올 수 있다

        googleMap.addMarker(myLocationMarker);
        googleMap.setMyLocationEnabled(true);
        googleMap.setOnMapClickListener(this);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(13));
    }
    // 일부 코드분할 필요


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

    // 내 위치 데이터 LatLng로 return! 합니다
    // MissingPermssion은 이미 권한 확인했는데도 오류 발생하고 있어서 SuppressLint로 무시
    @SuppressLint("MissingPermission")
    private LatLng getMyLocation() {
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        return new LatLng(location.getLatitude(), location.getLongitude());
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
            e.printStackTrace();
        }

        MarkerOptions clickLocationMarker = new MarkerOptions()
                .position(latLng)
                .title(locationAddressData);

        googleMap.clear();
        googleMap.addMarker(clickLocationMarker);
    }
}

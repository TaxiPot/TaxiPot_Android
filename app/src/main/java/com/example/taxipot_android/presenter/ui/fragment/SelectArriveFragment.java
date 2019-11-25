package com.example.taxipot_android.presenter.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentSelectArriveBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.tedpark.tedpermission.rx2.TedRx2Permission;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class SelectArriveFragment extends BaseFragment<FragmentSelectArriveBinding> implements OnMapReadyCallback {

    GoogleMap googleMap;
    MapView mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_select_arrive);
        View v = inflater.inflate(R.layout.fragment_select_arrive, container, false);
        binding.setFragment(this);

        getLocationPermission();

        mapView = (MapView) v.findViewById(R.id.mapview_arrive);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        return v;
    }

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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        // TODO : 기본 목적지가 있을텐데 거기 핑 찍고 위치이동하는 로직 장성
        // 내 프로필에서 저장해야됨
    }
}
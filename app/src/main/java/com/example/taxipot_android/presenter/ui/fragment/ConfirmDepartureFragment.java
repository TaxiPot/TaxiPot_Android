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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentConfirmDepartureBinding;
import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.presenter.viewModel.ConfirmTaxiPotViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.ConfirmTaxiPotViewModelFactory;
import com.example.taxipot_android.util.BaseNavigateFragment;
import com.example.taxipot_android.util.MapPosition;
import com.example.taxipot_android.util.ToastObserver;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tedpark.tedpermission.rx2.TedRx2Permission;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class ConfirmDepartureFragment extends BaseNavigateFragment<FragmentConfirmDepartureBinding> implements OnMapReadyCallback {

    @Inject
    ConfirmTaxiPotViewModelFactory factory;
    ConfirmTaxiPotViewModel viewModel;

    GoogleMap googleMap;
    MapView mapView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_confirm_departure);

        View v = super.onCreateView(inflater, container, savedInstanceState);

        getLocationPermission();
        mapView = (MapView) v.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        setAction(R.id.action_confirmDepartureFragment_to_confirmArriveFragment);

        viewModel = ViewModelProviders.of(requireActivity(),factory).get(ConfirmTaxiPotViewModel.class);
        viewModel.getTaxiPotList();

        viewModel.getTaxiPotSearchResult().observe(this, new Observer<List<TaxiPot>>() {
            @Override
            public void onChanged(List<TaxiPot> taxiPots) {
                if(taxiPots.size()<1) return;
                TaxiPot taxiPot = taxiPots.get(taxiPots.size()-1);

                LatLng latLng = new LatLng(taxiPot.getStartLatitude(),taxiPot.getStartLongtitude());

                MarkerOptions clickLocationMarker = new MarkerOptions()
                        .position(latLng)
                        .title(taxiPot.toString());

                googleMap.addMarker(clickLocationMarker);
            }
        });
        viewModel.getToast().observe(this, new ToastObserver(getContext()));

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

    // 맵 처음 나올 때 실행 (getMapAsync(this) 를 통해서! )
    // 일부 코드분할 필요
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

        googleMap.setMyLocationEnabled(true);
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
        //if(location!=null) return new LatLng(location.getLatitude(), location.getLongitude());
        return new LatLng(37.5,127);
    }
}

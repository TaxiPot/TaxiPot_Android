package com.example.taxipot_android.presenter.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentConfirmArriveBinding;
import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.presenter.ui.BaseFragment;
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

import javax.inject.Inject;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class ConfirmArriveFragment extends BaseNavigateFragment<FragmentConfirmArriveBinding> implements OnMapReadyCallback {

    @Inject
    ConfirmTaxiPotViewModelFactory factory;
    ConfirmTaxiPotViewModel viewModel;
    @Inject
    MapPosition mapPosition;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getLocationPermission();

        setFragmentLayout(R.layout.fragment_confirm_arrive);
        View v = super.onCreateView(inflater, container, savedInstanceState);
        setAction(R.id.action_confirmArriveFragment_to_makePartySeatFragment2);

        binding.mapviewConfirmArrive.onCreate(savedInstanceState);
        binding.mapviewConfirmArrive.onResume();

        setViewModel();
        initViewModelObserver();
        binding.setVm(viewModel);
        binding.setFragment(this);

        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(viewModel.getTaxiPot().getValue().toArriveLatLng()));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(13));
        googleMap.addMarker(getMarkerOptions(viewModel.getTaxiPot().getValue()));
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
                        binding.mapviewConfirmArrive.getMapAsync(this); // call onMapReady
                    } else {
                        makeToast("위치 권한을 허용해주세요.");
                        getActivity().finish();
                    }
                }, throwable -> {
                });
    }

    private MarkerOptions getMarkerOptions(TaxiPot taxiPot) { return new MarkerOptions().position(taxiPot.toArriveLatLng()).title(taxiPot.getStart()); }

    private void setViewModel() {
        viewModel = ViewModelProviders.of(requireActivity(), factory).get(ConfirmTaxiPotViewModel.class);
        viewModel.setNavigate(this);
    }

    private LatLng getDefaultLatLng() { return new LatLng(37.5, 127); }

    private void initViewModelObserver() { viewModel.getToast().observe(this, new ToastObserver(getContext())); }
}

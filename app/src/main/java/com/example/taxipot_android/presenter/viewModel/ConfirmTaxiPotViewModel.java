package com.example.taxipot_android.presenter.viewModel;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.usecase.ConfirmTaxiPotUseCase;
import com.example.taxipot_android.domain.usecase.ConfirmTaxiPotUseCaseImpl;
import com.example.taxipot_android.util.BaseObservable;
import com.example.taxipot_android.util.BaseViewModel;
import com.example.taxipot_android.util.ListLiveData;
import com.example.taxipot_android.util.Navigate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.util.Map;

public class ConfirmTaxiPotViewModel extends BaseViewModel implements GoogleMap.OnMarkerClickListener {

    private ListLiveData<TaxiPot> taxiPotSearchResult = new ListLiveData<>();

    private MutableLiveData<Integer> taxiPotIndex = new MutableLiveData<>();

    private MutableLiveData<TaxiPot> taxiPot = new MutableLiveData<>();

    private Map<Marker, Integer> markerMap;

    private Navigate navigate;

    public ConfirmTaxiPotViewModel(ConfirmTaxiPotUseCase useCase) {
        this.useCase = useCase;
    }

    public void getTaxiPotList() {
        ((ConfirmTaxiPotUseCase)useCase).getTaxiPotSearchResult(new TaxiPotSearchResultObservable());
    }

    public void nextFragment(View v) {
        Log.e(this.getClass().getSimpleName(),"nextFragment");
        ((ConfirmTaxiPotUseCase)useCase).cacheTaxiPot(taxiPotSearchResult.get(taxiPotIndex.getValue()));
        navigate.nextFragment();
    }

    private class TaxiPotSearchResultObservable extends BaseObservable<TaxiPot> {
        @Override
        public void onNext(TaxiPot taxiPot) {
            taxiPotSearchResult.add(taxiPot);
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            setToast("뭔가 에러가 났어요..");
        }

        @Override
        public void onComplete() {
            setToast("데이터 로딩 성공.");
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if(markerMap==null)return false;
        int index = markerMap.get(marker);
        taxiPotIndex.postValue(index);
        ((ConfirmTaxiPotUseCaseImpl)useCase).cacheTaxiPot(taxiPotSearchResult.get(index));
        taxiPot.postValue(taxiPotSearchResult.get(index));
        return false;
    }

    public void setNavigate(Navigate navigate) {
        this.navigate = navigate;
    }

    public MutableLiveData<TaxiPot> getTaxiPot() {
        return taxiPot;
    }

    public Map<Marker, Integer> getMarkerMap() {
        return markerMap;
    }

    public void setMarkerMap(Map<Marker, Integer> markerMap) {
        this.markerMap = markerMap;
    }

    public ListLiveData<TaxiPot> getTaxiPotSearchResult() {
        return taxiPotSearchResult;
    }

    public MutableLiveData<Integer> getTaxiPotIndex() {
        return taxiPotIndex;
    }
}

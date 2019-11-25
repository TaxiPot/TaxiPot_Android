package com.example.taxipot_android.presenter.viewModel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.usecase.SelectLocateUseCase;
import com.example.taxipot_android.util.BaseObservable;
import com.example.taxipot_android.util.BaseViewModel;

public class SelectLocateViewModel extends BaseViewModel {

    private MutableLiveData<Double> departLatitude = new MutableLiveData<>();
    private MutableLiveData<Double> departLongitude = new MutableLiveData<>();
    private MutableLiveData<Double> arriveLatitude = new MutableLiveData<>();
    private MutableLiveData<Double> arriveLongitude = new MutableLiveData<>();
    private MutableLiveData<Float> radius = new MutableLiveData<>();
    private MutableLiveData<Integer> year = new MutableLiveData<>();
    private MutableLiveData<Integer> month = new MutableLiveData<>();
    private MutableLiveData<Integer> day = new MutableLiveData<>();
    private MutableLiveData<Integer> hour = new MutableLiveData<>();
    private MutableLiveData<Integer> minute = new MutableLiveData<>();


    public SelectLocateViewModel(SelectLocateUseCase useCase) {
        this.useCase = useCase;
    }

    public void findTaxiPots(View v) {
        ((SelectLocateUseCase) useCase).findTaxiPots(
                departLatitude.getValue(),
                departLongitude.getValue(),
                arriveLatitude.getValue(),
                arriveLongitude.getValue(),
                radius.getValue(),
                year.getValue(),
                month.getValue(),
                day.getValue(),
                hour.getValue(),
                minute.getValue(),
                new SearchTaxiPotsObservable());
    }

    private class SearchTaxiPotsObservable extends BaseObservable<TaxiPot> {
        @Override
        public void onNext(TaxiPot taxiPot) {

        }

        @Override
        public void onError(Throwable e) {
            setToast("무언가 오류가 생겼어요..");
        }

        @Override
        public void onComplete() {
            setToast("방 검색이 완료되었어요.");
        }
    }
}

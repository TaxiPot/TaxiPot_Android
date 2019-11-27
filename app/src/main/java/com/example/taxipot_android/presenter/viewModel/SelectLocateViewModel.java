package com.example.taxipot_android.presenter.viewModel;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.usecase.SelectLocateUseCase;
import com.example.taxipot_android.util.BaseObservable;
import com.example.taxipot_android.util.BaseViewModel;
import com.example.taxipot_android.util.Navigate;

public class SelectLocateViewModel extends BaseViewModel {

    private MutableLiveData<String> depart = new MutableLiveData<>();
    private MutableLiveData<Double> departLatitude = new MutableLiveData<>();
    private MutableLiveData<Double> departLongitude = new MutableLiveData<>();
    private MutableLiveData<Double> arriveLatitude = new MutableLiveData<>();
    private MutableLiveData<Double> arriveLongitude = new MutableLiveData<>();
    private MutableLiveData<String> arrive = new MutableLiveData<>();
    private MutableLiveData<String> radiusStr = new MutableLiveData<>();
    private MutableLiveData<Boolean> tomorrow = new MutableLiveData<>(false);
    private MutableLiveData<Integer> hour = new MutableLiveData<>(0);
    private MutableLiveData<Integer> minute = new MutableLiveData<>(0);

    private Navigate navigate;

    public void setNavigate(Navigate navigate) {
        this.navigate = navigate;
    }

    public SelectLocateViewModel(SelectLocateUseCase useCase) {
        this.useCase = useCase;
    }

    public void findTaxiPots(View v) {
        float radius = Float.valueOf(radiusStr.getValue());
        ((SelectLocateUseCase) useCase).findTaxiPots(
                departLatitude.getValue(),
                departLongitude.getValue(),
                arriveLatitude.getValue(),
                arriveLongitude.getValue(),
                radius,
                hour.getValue(),
                minute.getValue(),
                tomorrow.getValue(),
                new SearchTaxiPotsObservable());
    }

    private class SearchTaxiPotsObservable extends BaseObservable<TaxiPot> {
        @Override
        public void onNext(TaxiPot taxiPot) {
            Log.e(this.getClass().getSimpleName(),taxiPot.toString());
        }

        @Override
        public void onError(Throwable e) {
            setToast(e.getMessage());
        }

        @Override
        public void onComplete() {
            setToast("방 검색이 완료되었어요.");
            navigate.nextFragment();
        }
    }

    public MutableLiveData<String> getArrive() {
        return arrive;
    }

    public MutableLiveData<String> getDepart() {
        return depart;
    }

    public MutableLiveData<Double> getDepartLatitude() {
        return departLatitude;
    }

    public MutableLiveData<Double> getDepartLongitude() {
        return departLongitude;
    }

    public MutableLiveData<Double> getArriveLatitude() {
        return arriveLatitude;
    }

    public MutableLiveData<Double> getArriveLongitude() {
        return arriveLongitude;
    }

    public MutableLiveData<String> getRadiusStr() {
        return radiusStr;
    }

    public MutableLiveData<Integer> getHour() {
        return hour;
    }

    public MutableLiveData<Integer> getMinute() {
        return minute;
    }

    public MutableLiveData<Boolean> getTomorrow() {
        return tomorrow;
    }
}

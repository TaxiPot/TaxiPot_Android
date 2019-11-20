package com.example.taxipot_android.presenter.viewModel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.usecase.MakePartyUseCase;
import com.example.taxipot_android.util.BaseSingle;
import com.example.taxipot_android.util.BaseViewModel;

public class MakePartyViewModel extends BaseViewModel {
    public MutableLiveData<String> departure = new MutableLiveData<>("출발지를 등록해주세요.");
    public MutableLiveData<String> arrive = new MutableLiveData<>("도착지를 등록해주세요.");
    public MutableLiveData<Boolean> onlySameGender = new MutableLiveData<>(false);
    public MutableLiveData<String> ageLowLimit = new MutableLiveData<>("00");
    public MutableLiveData<String> ageHighLimit = new MutableLiveData<>("99");
    public MutableLiveData<String> year = new MutableLiveData<>("2019");
    public MutableLiveData<String> month = new MutableLiveData<>("01");
    public MutableLiveData<String> day = new MutableLiveData<>("01");
    public MutableLiveData<String> hour = new MutableLiveData<>("00");
    public MutableLiveData<String> minute = new MutableLiveData<>("00");

    public MakePartyViewModel(MakePartyUseCase useCase) {
        this.useCase = useCase;
    }

    public void requestMakeTaxiPot(View v) {
        makeTaxiPot();
    }

    public void makeTaxiPot() {
        int ageLowLimit = strToInt(this.ageLowLimit.getValue());
        int ageHighLimit = strToInt(this.ageHighLimit.getValue());
        int year = strToInt(this.year.getValue());
        int month = strToInt(this.month.getValue());
        int day = strToInt(this.day.getValue());
        int hour = strToInt(this.hour.getValue());
        int minute = strToInt(this.minute.getValue());
        ((MakePartyUseCase)useCase).makeTaxiPot(departure.getValue(),arrive.getValue(),onlySameGender.getValue(),ageLowLimit,ageHighLimit,year,month,day,hour,minute, new MakeTaxiPotSingle());
    }

    private int strToInt(String str){
        return Integer.parseInt(str);
    }

    private class MakeTaxiPotSingle extends BaseSingle<TaxiPot> {
        @Override
        public void onSuccess(TaxiPot taxiPot) {
            setToast(taxiPot.dateFormat());
        }

        @Override
        public void onError(Throwable e) {
            setToast(e.getMessage());
        }
    }
}
package com.example.taxipot_android.presenter.viewModel;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.usecase.ConfirmTaxiPotUseCase;
import com.example.taxipot_android.util.BaseObservable;
import com.example.taxipot_android.util.BaseViewModel;
import com.example.taxipot_android.util.ListLiveData;

public class ConfirmTaxiPotViewModel extends BaseViewModel {

    private ListLiveData<TaxiPot> taxiPotSearchResult = new ListLiveData<>();

    private MutableLiveData<Integer> taxiPotIndex = new MutableLiveData<>(0);

    public ConfirmTaxiPotViewModel(ConfirmTaxiPotUseCase useCase) {
        this.useCase = useCase;
    }

    public ListLiveData<TaxiPot> getTaxiPotSearchResult() {
        return taxiPotSearchResult;
    }

    public void getTaxiPotList() {
        ((ConfirmTaxiPotUseCase)useCase).getTaxiPotSearchResult(new TaxiPotSearchResultObservable());
    }

    public void nextFragment(View v) {
        ((ConfirmTaxiPotUseCase)useCase).cacheTaxiPot(taxiPotSearchResult.get(taxiPotIndex.getValue()));
    }

    private class TaxiPotSearchResultObservable extends BaseObservable<TaxiPot> {
        @Override
        public void onNext(TaxiPot taxiPot) {
            Log.e(this.getClass().getSimpleName(),taxiPot.toString());
            taxiPotSearchResult.add(taxiPot);
        }

        @Override
        public void onError(Throwable e) {
            Log.e(this.getClass().getSimpleName(),e.getMessage());
            setToast("뭔가 에러가 났어요..");
        }

        @Override
        public void onComplete() {
            setToast("데이터 로딩 성공.");
        }
    }
}

package com.example.taxipot_android.presenter.viewModel;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.usecase.ConfirmTaxiPotUseCase;
import com.example.taxipot_android.util.BaseObservable;
import com.example.taxipot_android.util.BaseViewModel;
import com.example.taxipot_android.util.ListLiveData;

public class ConfirmTaxiPotViewModel extends BaseViewModel {

    private ListLiveData<TaxiPot> taxiPotSearchResult = new ListLiveData<>();

    public ConfirmTaxiPotViewModel(ConfirmTaxiPotUseCase useCase) {
        this.useCase = useCase;
    }

    public void getTaxiPotList() {
        ((ConfirmTaxiPotUseCase)useCase).getTaxiPotSearchResult(new TaxiPotSearchResultObservable());
    }

    private class TaxiPotSearchResultObservable extends BaseObservable<TaxiPot> {
        @Override
        public void onNext(TaxiPot taxiPot) {
            taxiPotSearchResult.add(taxiPot);
        }

        @Override
        public void onError(Throwable e) {
            setToast("뭔가 에러가 났어요..");
        }

        @Override
        public void onComplete() {
            setToast("데이터 로딩 성공.");
        }
    }
}

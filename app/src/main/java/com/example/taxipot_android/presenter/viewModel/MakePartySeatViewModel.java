package com.example.taxipot_android.presenter.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.usecase.MakePartySeatUseCase;
import com.example.taxipot_android.util.BaseSeatViewModel;
import com.example.taxipot_android.util.BaseSingle;
import com.example.taxipot_android.util.Navigate;

import java.util.List;

public class MakePartySeatViewModel extends BaseSeatViewModel {

    private Navigate navigate;
    private MutableLiveData<TaxiPot> taxiPot = new MutableLiveData<>();

    public MakePartySeatViewModel(MakePartySeatUseCase useCase) {
        this.useCase = useCase;
    }

    public void setNavigate(Navigate navigate) {
        this.navigate = navigate;
    }

    public LiveData<List<String>> getTaxiPot() {
        TaxiPot taxiPot = ((MakePartySeatUseCase)useCase).getTaxiPot();
        this.taxiPot.postValue(taxiPot);
        userSeatList.replaceAll(taxiPot.getSeatList());
        return userSeatList;
    }

    public void joinToTaxiPot(int seat_num) {
        ((MakePartySeatUseCase)useCase).joinToTaxiPot(seat_num, new JoinTaxiPotSingle());
    }

    private class JoinTaxiPotSingle extends BaseSingle<TaxiPot> {
        @Override
        public void onSuccess(TaxiPot taxiPot) {
            setToast(taxiPot.dateFormat());
            navigate.nextFragment();
        }

        @Override
        public void onError(Throwable e) {
            setToast(e.getMessage());
        }
    }
}

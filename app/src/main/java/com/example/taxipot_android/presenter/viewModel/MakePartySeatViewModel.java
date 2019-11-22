package com.example.taxipot_android.presenter.viewModel;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.usecase.MakePartySeatUseCase;
import com.example.taxipot_android.util.BaseSeatViewModel;
import com.example.taxipot_android.util.BaseSingle;

public class MakePartySeatViewModel extends BaseSeatViewModel {
    public MakePartySeatViewModel(MakePartySeatUseCase useCase) {
        this.useCase = useCase;
    }

    public void joinToTaxiPot(int seat_num) {
        ((MakePartySeatUseCase)useCase).joinToTaxiPot(seat_num, new JoinTaxiPotSingle());
    }

    private class JoinTaxiPotSingle extends BaseSingle<TaxiPot> {
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

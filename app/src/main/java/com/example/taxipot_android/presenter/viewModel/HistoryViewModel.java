package com.example.taxipot_android.presenter.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.repository.HistoryRepository;
import com.example.taxipot_android.domain.usecase.HistoryUseCase;
import com.example.taxipot_android.util.BaseObservable;
import com.example.taxipot_android.util.BaseViewModel;

import java.util.ArrayList;
import java.util.Calendar;

public class HistoryViewModel extends BaseViewModel {

    HistoryUseCase useCase;
    private ArrayList<LiveData<TaxiPot>> taxipotList;

    public HistoryViewModel(HistoryUseCase useCase) {
        this.useCase = useCase;
    }

    public ArrayList<LiveData<TaxiPot>> getTaxipotList(String userId) {
        useCase.getHistories(userId, new HistoryObservable());
        return taxipotList;
    }
    private class HistoryObservable extends BaseObservable<History> {
        @Override
        public void onNext(History history) {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }
}

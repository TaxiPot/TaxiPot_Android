package com.example.taxipot_android.presenter.viewModel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.example.taxipot_android.domain.entity.Report;
import com.example.taxipot_android.domain.usecase.ReportSelReasonUseCase;
import com.example.taxipot_android.util.BaseObservable;
import com.example.taxipot_android.util.BaseViewModel;

public class ReportSelReasonViewModel extends BaseViewModel {
    private MutableLiveData<Integer> selectPosition = new MutableLiveData<>(-1);

    public ReportSelReasonViewModel(ReportSelReasonUseCase useCase) {
        this.useCase = useCase;
    }

    public MutableLiveData<Integer> getSelectPosition() {
        return selectPosition;
    }

    public void doReport(View v) {
        ((ReportSelReasonUseCase)useCase).doReport(selectPosition.getValue(), new ReportObservable());
    }

    private class ReportObservable extends BaseObservable<Report> {
        @Override
        public void onNext(Report report) {

        }

        @Override
        public void onError(Throwable e) {
            setToast(e.getMessage());
        }

        @Override
        public void onComplete() {

        }
    }
}

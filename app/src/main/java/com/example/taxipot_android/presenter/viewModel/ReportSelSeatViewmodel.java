package com.example.taxipot_android.presenter.viewModel;

import android.util.Log;
import android.util.Pair;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.domain.usecase.ReportSelSeatUseCase;
import com.example.taxipot_android.util.BaseSeatViewModel;
import com.example.taxipot_android.util.BaseSingle;
import com.example.taxipot_android.util.Navigate;

import java.util.List;

public class ReportSelSeatViewmodel extends BaseSeatViewModel {

    public MutableLiveData<History> history = new MutableLiveData<>();
    public MutableLiveData<Boolean> successSaveReport = new MutableLiveData<>();
    private Navigate navigate;

    public ReportSelSeatViewmodel(ReportSelSeatUseCase useCase) {
        this.useCase = useCase;
    }

    public LiveData<List<String>> getUserSeatList() {
        return userSeatList;
    }

    public void getHistory() {
        ((ReportSelSeatUseCase)useCase).getHistory(new GetHistorySingle());
    }

    public void saveReportUser(Integer seatNum, Navigate navigate) {
        this.navigate = navigate;
        ((ReportSelSeatUseCase)useCase).saveReportUser(history.getValue(), seatNum, new SaveReportSingle());
    }

    private class GetHistorySingle extends BaseSingle<History> {
        @Override
        public void onSuccess(History history) {
            ReportSelSeatViewmodel.this.history.postValue(history);
            userSeatList.replaceAll(history.getSeatList());
            setToast("신고를 원하는 자리를 선택해주세요.");
        }

        @Override
        public void onError(Throwable e) {
            setToast("데이터를 불러오지 못했어요..");
        }
    }

    private class SaveReportSingle extends BaseSingle<String> {
        @Override
        public void onSuccess(String s) {
            navigate.nextFragment();
        }

        @Override
        public void onError(Throwable e) {
            setToast(e.getMessage());
        }
    }
}

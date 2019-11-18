package com.example.taxipot_android.presenter.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.domain.usecase.ReportSelSeatUseCase;
import com.example.taxipot_android.util.BaseSeatViewModel;
import com.example.taxipot_android.util.BaseSingle;

import java.util.List;

public class ReportSelSeatViewmodel extends BaseSeatViewModel {

    public MutableLiveData<History> history = new MutableLiveData<>();
    public ReportSelSeatViewmodel(ReportSelSeatUseCase useCase) {
        this.useCase = useCase;
    }

    public LiveData<List<String>> getUserSeatList() {
        return userSeatList;
    }

    public void getHistory() {
        ((ReportSelSeatUseCase)useCase).getHistory(new GetHistorySingle());
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
            setToast("데이터가 불러오지 못했어요..");
        }
    }
}

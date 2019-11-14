package com.example.taxipot_android.presenter.viewModel;

import android.util.Log;

import com.example.taxipot_android.data.api.HistoryApi;
import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.domain.usecase.HistoryUseCase;
import com.example.taxipot_android.util.BaseObservable;
import com.example.taxipot_android.util.BaseViewModel;
import com.example.taxipot_android.util.CreateRetrofit;
import com.example.taxipot_android.util.ListLiveData;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HistoryViewModel extends BaseViewModel {

    private ListLiveData<History> taxipotList = new ListLiveData<>();

    public HistoryViewModel(HistoryUseCase useCase) {
        this.useCase = useCase;
    }

    public ListLiveData<History> getTaxipotList() {
        return taxipotList;
    }

    public void getHistories(String userId) {
        Log.e(this.getClass().getSimpleName(),"getHistories");
        ((HistoryUseCase)useCase).getHistories(userId, new HistoryObservable());

    }

    private class HistoryObservable extends BaseObservable<List<History>> {

        @Override
        public void onNext(List<History> history) {
            Log.e(this.getClass().getSimpleName(),history.toString());
            taxipotList.addAll(history);
        }

        @Override
        public void onError(Throwable e) {
            setToast(e.getMessage());
        }

        @Override
        public void onComplete() {
            setToast("데이터 로딩 성공");
        }
    }
}

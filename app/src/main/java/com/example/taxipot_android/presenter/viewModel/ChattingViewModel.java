package com.example.taxipot_android.presenter.viewModel;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.example.taxipot_android.domain.entity.ChattingEntity;
import com.example.taxipot_android.domain.usecase.ChattingUseCase;
import com.example.taxipot_android.util.BaseObservable;
import com.example.taxipot_android.util.BaseViewModel;
import com.example.taxipot_android.util.ListLiveData;

public class ChattingViewModel extends BaseViewModel {

    ListLiveData<ChattingEntity> chattingList = new ListLiveData<>();
    public MutableLiveData<String> message = new MutableLiveData<>("");

    public ChattingViewModel(ChattingUseCase useCase) {
        this.useCase = useCase;
    }

    public void connect() {
        ((ChattingUseCase)useCase).connect(new ChattingObserver());
    }

    public void send(View v) {
        ((ChattingUseCase)useCase).send(message.getValue());
    }

    public void disconnect(View v) {
        ((ChattingUseCase)useCase).disconnect();
    }

    public void destroy() {
        ((ChattingUseCase)useCase).disconnect();
    }

    private class ChattingObserver extends BaseObservable<ChattingEntity> {
        @Override
        public void onNext(ChattingEntity chattingEntity) {
            chattingList.add(chattingEntity);
            Log.e(this.getClass().getSimpleName(),chattingEntity.toString());
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {
            dispose();
        }
    }

}

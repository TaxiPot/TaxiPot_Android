package com.example.taxipot_android.presenter.viewModel;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.example.taxipot_android.domain.entity.ChattingContent;
import com.example.taxipot_android.domain.entity.ChattingEntity;
import com.example.taxipot_android.domain.usecase.ChattingUseCase;
import com.example.taxipot_android.util.ActivityFinish;
import com.example.taxipot_android.util.BaseObservable;
import com.example.taxipot_android.util.BaseViewModel;
import com.example.taxipot_android.util.ListLiveData;

public class ChattingViewModel extends BaseViewModel {

    ActivityFinish finisher;
    public ListLiveData<ChattingEntity> chattingList = new ListLiveData<>();
    private MutableLiveData<String> message = new MutableLiveData<>("");

    public ChattingViewModel(ChattingUseCase useCase) {
        this.useCase = useCase;
    }

    public ActivityFinish getFinisher() {
        return finisher;
    }

    public MutableLiveData<String> getMessage() {
        return message;
    }

    public void setMessage(MutableLiveData<String> message) {
        this.message = message;
    }

    public void setFinisher(ActivityFinish finisher) {
        this.finisher = finisher;
    }

    public void connect() {
        ((ChattingUseCase)useCase).connect(new ChattingObserver());
    }

    public void send(View v) {
        ((ChattingUseCase)useCase).send(message.getValue());
        chattingList.add(new ChattingContent(-1,message.getValue(),true));
        message.postValue("");
    }

    public void disconnect(View v) {
        ((ChattingUseCase)useCase).disconnect();
        finisher.finish();
    }

    public void confidenceUp(View v, int seatNum) {
        ((ChattingUseCase)useCase).confidenceUp(seatNum);
    }

    public void confidenceDown(View v, int seatNum) {
        ((ChattingUseCase)useCase).confidenceDown(seatNum);
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

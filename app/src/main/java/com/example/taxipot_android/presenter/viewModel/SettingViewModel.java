package com.example.taxipot_android.presenter.viewModel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.example.taxipot_android.domain.entity.Bug;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.usecase.SettingUseCase;
import com.example.taxipot_android.presenter.ui.dialog.BugReportDialogListener;
import com.example.taxipot_android.presenter.ui.dialog.ChangePWDialogListener;
import com.example.taxipot_android.presenter.ui.dialog.IntroDeveloperDialogListener;
import com.example.taxipot_android.util.BaseSingle;
import com.example.taxipot_android.util.BaseViewModel;
import com.example.taxipot_android.util.DialogNavigate;

public class SettingViewModel extends BaseViewModel implements BugReportDialogListener, ChangePWDialogListener, IntroDeveloperDialogListener {
    private MutableLiveData<String> bugContent = new MutableLiveData<>("");
    private MutableLiveData<String> fromPW = new MutableLiveData<>("");
    private MutableLiveData<String> toPW = new MutableLiveData<>("");
    private MutableLiveData<String> dialogMessege = new MutableLiveData<>("추후 추가됩니다.");
    private DialogNavigate navigate;

    public SettingViewModel(SettingUseCase useCase) {
        this.useCase = useCase;
    }

    public void setNavigate(DialogNavigate navigate) {
        this.navigate = navigate;
    }

    @Override
    public MutableLiveData<String> getBugContent() {
        return bugContent;
    }

    @Override
    public MutableLiveData<String> getFromPW() {
        return fromPW;
    }

    @Override
    public MutableLiveData<String> getToPW() {
        return toPW;
    }

    @Override
    public MutableLiveData<String> getDialogMessege() {
        return dialogMessege;
    }

    @Override
    public void postBug(View v) {
        ((SettingUseCase)useCase).postBug(bugContent.getValue(), new BugPostObservable());
    }

    @Override
    public void changePW(View v) {
        ((SettingUseCase)useCase).changePW(fromPW.getValue(), toPW.getValue(), new ChangePWObservable());
    }

    @Override
    public void getMessege(View v) {

    }

    @Override
    public void dismiss(View v) {
        bugContent.postValue("");
        fromPW.postValue("");
        toPW.postValue("");

        dismiss();
    }

    private void dismiss() {
        navigate.dismiss();
    }

    private class BugPostObservable extends BaseSingle<Bug> {
        @Override
        public void onSuccess(Bug bug) {
            setToast("버그 접수가 완료되었습니다.");
            dismiss();
        }

        @Override
        public void onError(Throwable e) {
            setToast(e.getMessage());
        }
    }

    private class ChangePWObservable extends BaseSingle<User> {
        @Override
        public void onSuccess(User user) {
            setToast("비밀번호 변경이 완료되었습니다.");
            dismiss();
        }

        @Override
        public void onError(Throwable e) {
            setToast(e.getMessage());
        }
    }

    private class DialogMessegeObservable extends BaseSingle<String> {
        @Override
        public void onSuccess(String s) {

        }

        @Override
        public void onError(Throwable e) {

        }
    }
}

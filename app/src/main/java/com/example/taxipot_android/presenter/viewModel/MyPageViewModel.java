package com.example.taxipot_android.presenter.viewModel;

import androidx.lifecycle.MutableLiveData;

import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.usecase.SignInUseCase;
import com.example.taxipot_android.util.BaseSingle;
import com.example.taxipot_android.util.BaseViewModel;

public class MyPageViewModel extends BaseViewModel {
    public MutableLiveData<Integer> trustPoint = new MutableLiveData<>(0);
    public MutableLiveData<Boolean> isMan = new MutableLiveData<>(true);
    public MutableLiveData<Integer> age = new MutableLiveData<>(0);

    public MutableLiveData<String> basicsDepart = new MutableLiveData<>("기본 출발지를 선택해주세요.");
    public MutableLiveData<String> basicsArrive = new MutableLiveData<>("기본 도착지를 선택해주세요.");

    public String man = "남자";
    public String woman = "여자";

    public MyPageViewModel(SignInUseCase useCase) {
        this.useCase = useCase;
    }

    public void refreshUserData(User user) {
        ((SignInUseCase) useCase).signIn(user, new LoadMyPageObservable());
    }

    private class LoadMyPageObservable extends BaseSingle<User> {
        @Override
        public void onSuccess(User user) {
            age.postValue(user.getAge());
            trustPoint.postValue(user.getTrustPoint());
        }

        @Override
        public void onError(Throwable e) {
            setToast(e.getMessage());
        }
    }
}

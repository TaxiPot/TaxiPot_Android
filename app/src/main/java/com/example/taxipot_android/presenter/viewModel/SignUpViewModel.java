package com.example.taxipot_android.presenter.viewModel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.usecase.SignUpUseCase;
import com.example.taxipot_android.util.BaseSingle;
import com.example.taxipot_android.util.BaseViewModel;
import com.example.taxipot_android.util.Navigate;

public class SignUpViewModel extends BaseViewModel {

    public MutableLiveData<Boolean> isMan = new MutableLiveData<>(true);
    public MutableLiveData<String> ageLimit = new MutableLiveData<>("00");
    public MutableLiveData<Boolean> visibility = new MutableLiveData<>(false);

    public MutableLiveData<String> userId = new MutableLiveData<>();
    public MutableLiveData<String> userPassword = new MutableLiveData<>();
    public MutableLiveData<String> userPasswordCheck = new MutableLiveData<>();

    public Navigate navigate;

    public SignUpViewModel(SignUpUseCase useCase) {
        this.useCase = useCase;
    }

    public void setNavigate(Navigate navigate) {
        this.navigate = navigate;
    }

    public void signIn(View v) {
        String age = ageLimit.getValue();
        boolean isMan = this.isMan.getValue();
        String userId = this.userId.getValue();
        String userPassword = this.userPassword.getValue();
        String userPasswordCheck = this.userPasswordCheck.getValue();

        if (userId == null) {
            setToast("아이디를 입력해주세요.");
            return;
        } else if (userPassword == null) {
            setToast("비밀번호를 입력해주세요.");
            return;
        } else if (userPasswordCheck == null) {
            setToast("비밀번호 확인을 입력해주세요.");
            return;
        } else if (userPassword == userPasswordCheck) {
            setToast("비밀번호가 동일하지 않습니다.");
            return;
        } else if (age.isEmpty()) {
            setToast("나이를 입력해주세요.");
            return;
        }
        User user = new User(Integer.parseInt(age),isMan,userId,userPassword);
        ((SignUpUseCase)useCase).signUp(user, new SignUpObservable());
    }
    class SignUpObservable extends BaseSingle<User> {
        @Override
        public void onSuccess(User user) {
            setToast("회원가입에 성공하였습니다.");
            navigate.nextFragment();
        }

        @Override
        public void onError(Throwable e) {
            setToast(e.getMessage());
        }
    }
}

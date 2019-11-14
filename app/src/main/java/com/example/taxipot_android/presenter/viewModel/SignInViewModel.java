package com.example.taxipot_android.presenter.viewModel;

import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taxipot_android.data.api.UserApi;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.repository.SignInRepository;
import com.example.taxipot_android.domain.usecase.SignInUseCase;
import com.example.taxipot_android.util.BaseSingle;
import com.example.taxipot_android.util.BaseViewModel;
import com.example.taxipot_android.util.CreateRetrofit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SignInViewModel extends BaseViewModel {
    public MutableLiveData<String> userId = new MutableLiveData<>();
    public MutableLiveData<String> userPassword = new MutableLiveData<>();
    public MutableLiveData<User> user = new MutableLiveData<>();

    public SignInViewModel(SignInUseCase useCase) {
        this.useCase = useCase;
    }

    public void signIn(View v) {
        String id = userId.getValue();
        String password = userPassword.getValue();
        if(id==null || password==null) {
            setToast("아이디와 비밀번호를 모두 입력해주세요.");
        } else {
            User user = new User(id,password);
            ((SignInUseCase)useCase).signIn(user,new SignInObservable());

        }
    }

    private class SignInObservable extends BaseSingle<User> {
        @Override
        public void onSuccess(User user) {
            SignInViewModel.this.user.postValue(user);
            setToast("로그인에 성공하였습니다.");
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            setToast(e.getMessage());
        }
    }
}

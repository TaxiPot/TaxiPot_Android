package com.example.taxipot_android.presenter.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.taxipot_android.R;
import com.example.taxipot_android.data.api.UserApi;
import com.example.taxipot_android.databinding.ActivitySignInBinding;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.presenter.ui.BaseActivity;
import com.example.taxipot_android.presenter.viewModel.SignInViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.SignInViewModelFactory;
import com.example.taxipot_android.util.CreateRetrofit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class SignInActivity extends BaseActivity {

    ActivitySignInBinding binding;

    SignInViewModel viewModel;
    SignInViewModelFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, factory).get(SignInViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);
        binding.setActivity(this);
    }

    public void doSignUp(View v) {
        startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
    }

    public void doSignIn(View v) {
        String userId = viewModel.userId.getValue();
        String userPassword = viewModel.userPassword.getValue();

        if (userId.isEmpty()) {
            makeToast("아이디를 입력해주세요.");
        } else if (userPassword.isEmpty()) {
            makeToast("비밀번호를 입력해주세요.");
        }

        User user = new User(userId, userPassword);

        CreateRetrofit.createRetrofit(UserApi.class)
                .requestSignIn(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<User>() {
                    @Override
                    public void onSuccess(User user) {
                        makeToast("로그인에 성공했습니다.");
                        startActivity(new Intent(SignInActivity.this, MainActivity.class));
                        finish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        makeToast("로그인에 실패했습니다.");
                    }
                });
    }
}

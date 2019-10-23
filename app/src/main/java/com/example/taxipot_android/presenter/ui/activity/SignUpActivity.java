package com.example.taxipot_android.presenter.ui.activity;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.example.taxipot_android.R;
import com.example.taxipot_android.data.api.UserApi;
import com.example.taxipot_android.databinding.ActivitySignUpBinding;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.presenter.ui.BaseActivity;
import com.example.taxipot_android.presenter.viewModel.SignUpViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.SignUpViewModelFactory;
import com.example.taxipot_android.util.CreateRetrofit;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class SignUpActivity extends BaseActivity {

    ActivitySignUpBinding binding;
    @Inject
    SignUpViewModelFactory factory;
    SignUpViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);
        viewModel = ViewModelProviders.of(this, factory).get(SignUpViewModel.class);
        binding.setVm(viewModel);
        binding.setActivity(this);
        liveDataObserve();
    }

    private void changeTextColorRadioButton(RadioButton selView, RadioButton view) {
        selView.setTextColor(Color.WHITE);
        view.setTextColor(ContextCompat.getColor(SignUpActivity.this, R.color.barColor));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void liveDataObserve() {
        viewModel.isMan.observe(this, aBoolean -> {
            if (aBoolean) {
                changeTextColorRadioButton(binding.signup2GenderIsManRb, binding.signup2GenderIsWomanRb);
            } else {
                changeTextColorRadioButton(binding.signup2GenderIsWomanRb, binding.signup2GenderIsManRb);
            }
        });

        viewModel.ageLimit.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s.length() == 0) {
                    viewModel.ageLimit.postValue("00");
                } else {
                    if (Integer.parseInt(s) > 99) {
                        viewModel.ageLimit.postValue("99");
                        binding.signupAgeEt.setText("99");
                    } else if (Integer.parseInt(s) < 0) {
                        viewModel.ageLimit.postValue("00");
                        binding.signupAgeEt.setText("00");
                    }
                }
            }
        });
    }

    public void requestSignUpActivity(View v) {
        @Nullable
        String age = viewModel.ageLimit.getValue();
        boolean isMan = viewModel.isMan.getValue();
        String userId = viewModel.userId.getValue();
        String userPassword = viewModel.userPassword.getValue();
        String userPasswordCheck = viewModel.userPasswordCheck.getValue();

        if (userId == null) {
            makeToast("아이디를 입력해주세요.");
        } else if (userPassword == null) {
            makeToast("비밀번호를 입력해주세요.");
        } else if (userPasswordCheck == null) {
            makeToast("비밀번호 확인을 입력해주세요.");
        } else if (userPassword == userPasswordCheck) {
            makeToast("비밀번호가 동일하지 않습니다.");
        } else if (age.isEmpty()) {
            makeToast("나이를 입력해주세요.");
        }

        User user = new User(Integer.valueOf(age), isMan, userId, userPassword);
        Log.d("user", user.toString());

        CreateRetrofit.createRetrofit(UserApi.class)
                .requestSignUp(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<User>() {
                    @Override
                    public void onSuccess(User responseBody) {
                        makeToast("회원가입에 성공했습니다.");
                        Log.d("success", "success");
                        finish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        makeToast("서버와 통신할 수 없습니다. 인터넷을 확인하세요.");
                    }
                });
    }
}
}
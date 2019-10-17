package com.example.taxipot_android.presenter.ui.activity;

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
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

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
                if (Integer.parseInt(s) > 99) {
                    viewModel.ageLimit.postValue("99");
                } else if (Integer.parseInt(s) < 0) {
                    viewModel.ageLimit.postValue("00");
                }
            }
        });
    }

    public void requestSignUpActivity(View v) {
        CreateRetrofit.createRetrofit(UserApi.class)
                .requestSignUp(new User(50, false, "00l3", "pass"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        makeToast("회원가입에 성공했습니다.");
                        Log.d("success", "success");
                    }

                    @Override
                    public void onError(Throwable e) {
                        viewModel.visibility.setValue(true);
                        switch (e.getMessage()) {
                            case "HTTP 400" : { break; }
                            case "timeout" : { makeToast("인터넷 상태를 확인 후 다시 시도해주세요."); }
                        }
                        viewModel.visibility.setValue(false);
                    }
                });
    }

    private void changeTextColorRadioButton(RadioButton selView, RadioButton view) {
        selView.setTextColor(Color.WHITE);
        view.setTextColor(ContextCompat.getColor(SignUpActivity.this, R.color.barColor));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

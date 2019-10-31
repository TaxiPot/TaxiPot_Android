package com.example.taxipot_android.presenter.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taxipot_android.domain.repository.SignInRepository;

public class SignInViewModel extends ViewModel {
    public MutableLiveData<String> userId = new MutableLiveData<>();
    public MutableLiveData<String> userPassword = new MutableLiveData<>();
    private SignInRepository repository;

    public SignInViewModel(SignInRepository repository) {
        this.repository = repository;
    }
}

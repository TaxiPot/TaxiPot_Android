package com.example.taxipot_android.di.module.fragment;

import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.data.repository.SettingRepositoryImpl;
import com.example.taxipot_android.data.validation.SettingValidation;
import com.example.taxipot_android.data.validation.SettingValidationImpl;
import com.example.taxipot_android.domain.repository.SettingRepository;
import com.example.taxipot_android.domain.usecase.SettingUseCase;
import com.example.taxipot_android.domain.usecase.SettingUseCaseImpl;
import com.example.taxipot_android.presenter.viewModelFactory.SettingViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingFragmentModule {

    @Provides
    public SettingViewModelFactory factory(SettingUseCase useCase) {
        return new SettingViewModelFactory(useCase);
    }

    @Provides
    public SettingUseCase useCase(SettingValidation validation) {
        return new SettingUseCaseImpl(validation);
    }

    @Provides
    public SettingValidation validation(SettingRepository repository) {
        return new SettingValidationImpl(repository);
    }

    @Provides
    public SettingRepository repository(RemoteAPI api) {
        return new SettingRepositoryImpl(api);
    }
}

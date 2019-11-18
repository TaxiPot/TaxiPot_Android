package com.example.taxipot_android.di.module.fragment;

import com.example.taxipot_android.data.cache.ReportCache;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.data.repository.ReportSelReasonRepositoryImpl;
import com.example.taxipot_android.domain.repository.ReportSelReasonRepository;
import com.example.taxipot_android.domain.usecase.ReportSelReasonUseCase;
import com.example.taxipot_android.domain.usecase.ReportSelReasonUseCaseImpl;
import com.example.taxipot_android.presenter.viewModelFactory.ReportSelReasonViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ReportSelReasonFragmentModule {
    @Provides
    public ReportSelReasonViewModelFactory factory(ReportSelReasonUseCase useCase) {
        return new ReportSelReasonViewModelFactory(useCase);
    }

    @Provides
    public ReportSelReasonUseCase useCase(ReportSelReasonRepository repository){
        return new ReportSelReasonUseCaseImpl(repository);
    }

    @Provides
    public ReportSelReasonRepository repository(RemoteAPI api, ReportCache cache) {
        return new ReportSelReasonRepositoryImpl(api, cache);
    }
}

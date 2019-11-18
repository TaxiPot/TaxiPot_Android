package com.example.taxipot_android.di.module.fragment;

import com.example.taxipot_android.data.cache.HistoryCache;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.data.repository.ReportSelSeatRepositoryImpl;
import com.example.taxipot_android.domain.repository.ReportSelSeatRepository;
import com.example.taxipot_android.domain.usecase.ReportSelSeatUseCase;
import com.example.taxipot_android.domain.usecase.ReportSelSeatUseCaseImpl;
import com.example.taxipot_android.presenter.viewModelFactory.ReportSelSeatViewmodelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ReportSelSeatFragmentModule {
    @Provides
    public ReportSelSeatViewmodelFactory factory(ReportSelSeatUseCase useCase) {
        return new ReportSelSeatViewmodelFactory(useCase);
    }

    @Provides
    public ReportSelSeatUseCase useCase(ReportSelSeatRepository repository) {
        return new ReportSelSeatUseCaseImpl(repository);
    }

    @Provides
    public ReportSelSeatRepository repository(RemoteAPI api, HistoryCache cache) {
        return new ReportSelSeatRepositoryImpl(api,cache);
    }
}

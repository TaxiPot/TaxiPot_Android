package com.example.taxipot_android.di.module.fragment;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.data.repository.HistoryRepositoryImpl;
import com.example.taxipot_android.domain.repository.HistoryRepository;
import com.example.taxipot_android.presenter.viewModelFactory.HistoryViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class HistoryFragmentModule {
    @Provides
    public HistoryViewModelFactory provideViewModelFactory(HistoryRepository repository) {
        return new HistoryViewModelFactory(repository);
    }

    @Provides
    public HistoryRepository historyRepository(RemoteAPI api) {
        return new HistoryRepositoryImpl(api);
    }
}

package com.example.taxipot_android.di.module.activity;

import com.example.taxipot_android.data.remote.WebSocketHandler;
import com.example.taxipot_android.data.repository.ChattingRepositoryImpl;
import com.example.taxipot_android.domain.repository.ChattingRepository;
import com.example.taxipot_android.domain.usecase.ChattingUseCase;
import com.example.taxipot_android.domain.usecase.ChattingUseCaseImpl;
import com.example.taxipot_android.presenter.viewModelFactory.ChattingViewModelFactory;

import java.net.URI;

import dagger.Module;
import dagger.Provides;

@Module
public class ChattingActivityModule {
    @Provides
    public ChattingViewModelFactory factory(ChattingUseCase useCase) {
        return new ChattingViewModelFactory(useCase);
    }

    @Provides
    public ChattingUseCase useCase(ChattingRepository repository) {
        return new ChattingUseCaseImpl(repository);
    }

    @Provides
    public ChattingRepository repository(WebSocketHandler handler) {
        return new ChattingRepositoryImpl(handler);
    }

    @Provides
    public WebSocketHandler client(URI uri) {
        if(uri == null) return null;
        return new WebSocketHandler(uri);
    }
}

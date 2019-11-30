package com.example.taxipot_android.domain.repository;

import com.example.taxipot_android.domain.entity.ChattingEntity;

import io.reactivex.subjects.PublishSubject;

public interface ChattingRepository {

    PublishSubject<ChattingEntity> connect();

    void sendMessage(String message);

    void disconnect();

}

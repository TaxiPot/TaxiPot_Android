package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.remote.WebSocketHandler;
import com.example.taxipot_android.di.application.BaseApplication;
import com.example.taxipot_android.domain.entity.ChattingEntity;
import com.example.taxipot_android.domain.repository.ChattingRepository;

import io.reactivex.subjects.PublishSubject;

public class ChattingRepositoryImpl implements ChattingRepository {

    private int roomId; //TODO BaseApplication에서 roomId 가져와서 초기화시키자.(서버도 같이 손봐야함.)
    private int seatNum;
    private WebSocketHandler socket;
    private PublishSubject<ChattingEntity> publishSubject;

    public ChattingRepositoryImpl(WebSocketHandler socket) {
        this.socket = socket;
        roomId = getRoomId();
        seatNum = getSeatNum();
    }

    private Integer getRoomId() {return BaseApplication.getUser().getRoomId(); }
    private Integer getSeatNum() {return BaseApplication.getUser().getSeatNum();}

    @Override
    public PublishSubject<ChattingEntity> connect() {
        publishSubject = PublishSubject.create();
        socket.setPublishSubject(publishSubject);
        socket.setRoomId(getRoomId());
        socket.setSeatNum(getSeatNum());
        socket.connect();
        return publishSubject;
    }

    @Override
    public void sendMessage(String message) {
        socket.send(roomId + ",MESSAGE," + message); // {roomId},MESSAGE,{content}
    }

    @Override
    public void disconnect() {
        if(socket.isClosed()) return;
        socket.send(roomId+",DISCONNECT," + seatNum); // {roomId},DISCONNECT
        socket.close();
    }

}
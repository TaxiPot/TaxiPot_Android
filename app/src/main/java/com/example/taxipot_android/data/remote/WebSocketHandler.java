package com.example.taxipot_android.data.remote;

import android.util.Log;
import android.util.Pair;

import com.example.taxipot_android.domain.entity.ChattingEntity;
import com.example.taxipot_android.domain.mapper.ChattingEntityMapper;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

import io.reactivex.subjects.PublishSubject;

public class WebSocketHandler extends WebSocketClient {

    private PublishSubject<ChattingEntity> publishSubject;

    private int roomId;
    private int seatNum;

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public void setPublishSubject(PublishSubject<ChattingEntity> publishSubject) {
        this.publishSubject = publishSubject;
    }

    public WebSocketHandler(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        Log.e(this.getClass().getSimpleName(), "onOpen");
        send(roomId+",JOIN,"+seatNum);
    }

    @Override
    public void onMessage(String message) {
        Log.e(this.getClass().getSimpleName(),"onMessage : "+message);
        publishSubject.onNext(ChattingEntityMapper.create(messageListToPair(splitMessage(message))));
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        publishSubject.onComplete();
    }

    @Override
    public void onError(Exception ex) {

    }

    private String[] splitMessage(String message) {
        return message.split(":");
    }

    private Pair<Integer, String> messageListToPair(String[] strings) {
        Integer seatNum = Integer.valueOf(strings[0].trim());
        String message = strings[1].trim();
        return Pair.create(seatNum, message);
    }
}

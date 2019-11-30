package com.example.taxipot_android.domain.entity;

import androidx.annotation.NonNull;

public class ChattingContent implements ChattingEntity{
    int seatNum;
    String content;
    boolean myChat;

    public ChattingContent(int seatNum, String content) {
        this.seatNum = seatNum;
        this.content = content;
    }

    public ChattingContent(int seatNum, String content, boolean myChat) {
        this.seatNum = seatNum;
        this.content = content;
        this.myChat = myChat;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @NonNull
    @Override
    public String toString() {
        return seatNum + content;
    }
}

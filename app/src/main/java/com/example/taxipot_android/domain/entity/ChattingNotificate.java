package com.example.taxipot_android.domain.entity;

import androidx.annotation.NonNull;

public class ChattingNotificate implements ChattingEntity{
    String value;
    int seatNum;

    public ChattingNotificate(String value, int seatNum) {
        this.value = value;
        this.seatNum = seatNum;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getSeatNum() {
        return seatNum;
    }

    @NonNull
    @Override
    public String toString() {
        return seatNum + value;
    }
}

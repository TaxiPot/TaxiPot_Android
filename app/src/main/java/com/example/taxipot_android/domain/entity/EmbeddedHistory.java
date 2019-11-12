package com.example.taxipot_android.domain.entity;

import com.google.gson.annotations.SerializedName;

public class EmbeddedHistory {
    @SerializedName("roomId")
    private int roomId;
    @SerializedName("userId")
    private String userId;

    public int getRoomId() {
        return roomId;
    }

    public String getUserId() {
        return userId;
    }

    public EmbeddedHistory() {
    }

    public EmbeddedHistory(int roomId, String userId) {
        this.roomId = roomId;
        this.userId = userId;
    }
}

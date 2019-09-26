package com.example.taxipot_android.domain.entity;

import com.google.gson.annotations.SerializedName;

class EmbeddedHistory {
    @SerializedName("roomId")
    private int roomId;
    @SerializedName("userId")
    private String userId;
}

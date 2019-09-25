package com.example.taxipot_android.domain.entity;

import com.google.gson.annotations.SerializedName;

public class History {
    @SerializedName("first_seat")
    private String firstSeat;
    @SerializedName("second_seat")
    private String  secondSeat;
    @SerializedName("third_seat")
    private String  thirdSeat;
    @SerializedName("fourth_seat")
    private String fourthSeat;
    @SerializedName("userRoomId")
    private EmbeddedHistory userRoomId;
}

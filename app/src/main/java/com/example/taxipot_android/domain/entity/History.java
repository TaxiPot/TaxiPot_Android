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

    public History() {
    }

    public History(String firstSeat, String secondSeat, String thirdSeat, String fourthSeat, EmbeddedHistory userRoomId) {
        this.firstSeat = firstSeat;
        this.secondSeat = secondSeat;
        this.thirdSeat = thirdSeat;
        this.fourthSeat = fourthSeat;
        this.userRoomId = userRoomId;
    }

    public String getFirstSeat() {
        return firstSeat;
    }

    public String getSecondSeat() {
        return secondSeat;
    }

    public String getThirdSeat() {
        return thirdSeat;
    }

    public String getFourthSeat() {
        return fourthSeat;
    }

    public EmbeddedHistory getUserRoomId() {
        return userRoomId;
    }
}

package com.example.taxipot_android.domain.entity;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    @SerializedName("start_longtitude")
    private float start_longtitude;
    @SerializedName("start_latitude")
    private float start_latitude;
    @SerializedName("end_longtitude")
    private float end_longtitude;
    @SerializedName("end_latitude")
    private float end_latitude;
    @SerializedName("departTime")
    private long depart_time;

    private String start;
    private String finish;

    public History() {
    }
    public History(Integer i) {
        start_longtitude = i.floatValue();
    }

    public History(String firstSeat, String secondSeat, String thirdSeat, String fourthSeat, EmbeddedHistory userRoomId, float start_longtitude, float start_latitude, float end_longtitude, float end_latitude, long depart_time) {
        this.firstSeat = firstSeat;
        this.secondSeat = secondSeat;
        this.thirdSeat = thirdSeat;
        this.fourthSeat = fourthSeat;
        this.userRoomId = userRoomId;
        this.start_longtitude = start_longtitude;
        this.start_latitude = start_latitude;
        this.end_longtitude = end_longtitude;
        this.end_latitude = end_latitude;
        this.depart_time = depart_time;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setFinish(String finish) {
        this.finish = finish;
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

    public float getStart_longtitude() {
        return start_longtitude;
    }

    public float getStart_latitude() {
        return start_latitude;
    }

    public float getEnd_longtitude() {
        return end_longtitude;
    }

    public float getEnd_latitude() {
        return end_latitude;
    }

    public long getDepart_time() {
        return depart_time;
    }

    public String startToFinish() {
        return start + "\n" + finish;
    }
    public String dateFormat() {
        return format.format(new Date(depart_time));
    }

    private SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm");

    @Override
    public String toString() {
        return "History{" +
                "firstSeat='" + firstSeat + '\'' +
                ", secondSeat='" + secondSeat + '\'' +
                ", thirdSeat='" + thirdSeat + '\'' +
                ", fourthSeat='" + fourthSeat + '\'' +
                ", userRoomId=" + userRoomId +
                ", start_longtitude=" + start_longtitude +
                ", start_latitude=" + start_latitude +
                ", end_longtitude=" + end_longtitude +
                ", end_latitude=" + end_latitude +
                ", depart_time=" + depart_time +
                ", format=" + format +
                '}';
    }
}

package com.example.taxipot_android.domain.entity;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TaxiPot {
    @SerializedName("room_id")
    private int roomid;
    @SerializedName("start_longtitude")
    private double startLongtitude;
    @SerializedName("start_latitude")
    private double startLatitude;
    @SerializedName("end_longtitude")
    private double endLongtitude;
    @SerializedName("end_latitude")
    private double endLatitude;
    @SerializedName("start_age")
    private int startAge;
    @SerializedName("end_age")
    private int endAge;
    @SerializedName("gender_man")
    private boolean genderMan;
    @SerializedName("gender_woman")
    private boolean genderWoman;
    @SerializedName("first_seat")
    private String firstSeat;
    @SerializedName("second_seat")
    private String  secondSeat;
    @SerializedName("third_seat")
    private String thirdSeat;
    @SerializedName("fourth_seat")
    private String fourthSeat;

    private Calendar departTime;
    // TODO : departTime 을 Long 형으로 받아올 때, Format 에 적용할 때에 오류가 발생함.
    private String start;
    private String finish;

    private SimpleDateFormat format;
    public TaxiPot() {
        format = new SimpleDateFormat("MM/dd HH:mm");
    }

    public TaxiPot(Calendar time, String start, String finish) {
        this();
        departTime = time;
        this.start = start;
        this.finish = finish;
    }

    public String startToFinish() {
        return start + " ~ " + finish;
    }
    public String dateFormat() {
        return format.format(departTime.getTime());
    }
}

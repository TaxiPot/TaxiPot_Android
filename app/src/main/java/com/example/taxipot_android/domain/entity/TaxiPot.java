package com.example.taxipot_android.domain.entity;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    private String secondSeat;
    @SerializedName("third_seat")
    private String thirdSeat;
    @SerializedName("fourth_seat")
    private String fourthSeat;
    @SerializedName("departTime")
    private long departTime;
    // TODO : departTime 을 Long 형으로 받아올 때, Format 에 적용할 때에 오류가 발생함.
    private boolean onlySameGender;
    private String start;
    private String finish;

    private SimpleDateFormat format;

    public TaxiPot() {
        format = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
    }

    public TaxiPot(Calendar time, String start, String finish) {
        this();
        departTime = time.getTime().getTime();
        this.start = start;
        this.finish = finish;
    }

    public TaxiPot(String start, String finish, boolean onlySameGender, int startAge, int endAge, long departTime) {
        this.startAge = startAge;
        this.endAge = endAge;
        this.onlySameGender = onlySameGender;
        this.departTime = departTime;
        this.start = start;
        this.finish = finish;
        this.genderMan = true;
        this.genderWoman = true;
    }

    public TaxiPot(double startLongtitude, double startLatitude, double endLongtitude, double endLatitude, long departTime) {
        this.startLongtitude = startLongtitude;
        this.startLatitude = startLatitude;
        this.endLongtitude = endLongtitude;
        this.endLatitude = endLatitude;
        this.departTime = departTime;
    }

    public String startToFinish() {
        return start + " ~ " + finish;
    }

    public String dateFormat() {
        return format.format(new Date(departTime));
    }

    public double getStartLongtitude() {
        return startLongtitude;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public double getEndLongtitude() {
        return endLongtitude;
    }

    public double getEndLatitude() {
        return endLatitude;
    }

    public long getDepartTime() {
        return departTime;
    }

    public int getRoomid() {
        return roomid;
    }

    public int getStartAge() {
        return startAge;
    }

    public int getEndAge() {
        return endAge;
    }

    public boolean isGenderMan() {
        return genderMan;
    }

    public boolean isGenderWoman() {
        return genderWoman;
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

    public String getStart() {
        return start;
    }

    public String getFinish() {
        return finish;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }

    public boolean isOnlySameGender() {
        return onlySameGender;
    }

    public void setGenderMan(boolean genderMan) {
        this.genderMan = genderMan;
    }

    public void setGenderWoman(boolean genderWoman) {
        this.genderWoman = genderWoman;
    }

    public void setStartLongtitude(double startLongtitude) {
        this.startLongtitude = startLongtitude;
    }

    public void setStartLatitude(double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public void setEndLongtitude(double endLongtitude) {
        this.endLongtitude = endLongtitude;
    }

    public void setEndLatitude(double endLatitude) {
        this.endLatitude = endLatitude;
    }

    public List<String> getSeatList() {
        List<String> list = new ArrayList<>();
        list.add(firstSeat);
        list.add(secondSeat);
        list.add(thirdSeat);
        list.add(fourthSeat);
        return list;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        String man = "";
        String woman = "";
        if (genderMan) man = "남";
        if (genderWoman) woman = "여";
        return "입장 가능 나이 : " + startAge + " ~ " + endAge + "\n"
                + man + " " + woman + " 입장 가능\n"
                + "출발 시간 : " + format.format(departTime) + "\n"
                + "출발 : " + start + " 도착 : " + finish;
    }
}

package com.example.taxipot_android.domain.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TaxiPot {
    private int roomid;
    private double start_longtitude;
    private double start_latitude;
    private double finish_longtitude;
    private double finish_latitude;
    private Calendar depart_time;
    private boolean gender;
    private int start_age;
    private int end_age;
    private int first_seat;
    private int second_seat;
    private int third_seat;
    private int fourth_seat;
    private String start;
    private String finish;
    private SimpleDateFormat format;
    public TaxiPot(Calendar time, String start, String finish) {
        this();
        depart_time = time;
        this.start = start;
        this.finish = finish;
    }
    TaxiPot() {
        format = new SimpleDateFormat("MM/dd HH:mm");
    }
    public String startToFinish() {
        return start + " ~ " + finish;
    }
    public String dateFormat() {
        return format.format(depart_time.getTime());
    }
}

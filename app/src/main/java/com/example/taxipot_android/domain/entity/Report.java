package com.example.taxipot_android.domain.entity;

import com.google.gson.annotations.SerializedName;

public class Report {
    @SerializedName("reason_num")
    private int reasonNum;
    @SerializedName("reportUserId")
    private String reportUserId;
    @SerializedName("reportedUserId")
    private String reportedUserId;

    public Report() {
    }

    public Report(int reasonNum, String reportUserId, String reportedUserId) {
        this.reasonNum = reasonNum;
        this.reportUserId = reportUserId;
        this.reportedUserId = reportedUserId;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reasonNum=" + reasonNum +
                ", reportUserId='" + reportUserId + '\'' +
                ", reportedUserId='" + reportedUserId + '\'' +
                '}';
    }
}
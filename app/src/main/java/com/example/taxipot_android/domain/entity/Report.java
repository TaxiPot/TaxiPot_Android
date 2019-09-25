package com.example.taxipot_android.domain.entity;

import com.google.gson.annotations.SerializedName;

public class Report {
    @SerializedName("reason_num")
    private int reasonNum;
    @SerializedName("reportUserId")
    private String reportUserId;
    @SerializedName("reportUserId")
    private String reportedUserId;
}
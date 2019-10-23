package com.example.taxipot_android.domain.entity;


import com.google.gson.annotations.SerializedName;

public class Bug {
    @SerializedName("bug_id")
    private int bugId;
    @SerializedName("content")
    private String content;
    @SerializedName("user_id")
    private String userId;

}
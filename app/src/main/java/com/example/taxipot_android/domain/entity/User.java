package com.example.taxipot_android.domain.entity;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("age")
    private int age;
    @SerializedName("gender")
    private boolean isMan;
    @SerializedName("trust_point")
    private int trustPoint;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("user_password")
    private String userPassword;

    public User(int age, boolean isMan, String userId, String userPassword) {
        this.age = age;
        this.isMan = isMan;
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public int getTrustPoint() {
        return trustPoint;
    }

    public void setTrustPoint(int trustPoint) {
        this.trustPoint = trustPoint;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}

package com.example.taxipot_android.util;

import java.util.ArrayList;
import java.util.List;

public class ReportReasonList {
    public static List<String> getReportReasonList(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("말이 너무 많아요");
        arrayList.add("너무 못생겼어요");
        arrayList.add("프로필 정보와 달라요");
        arrayList.add("돈을 안내요");
        arrayList.add("늦게 왔어요");
        arrayList.add("그냥 싫어요");
        return arrayList;
    }
}

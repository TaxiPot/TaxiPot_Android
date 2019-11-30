package com.example.taxipot_android.domain.mapper;

import android.util.Pair;

import com.example.taxipot_android.domain.entity.ChattingContent;
import com.example.taxipot_android.domain.entity.ChattingEntity;
import com.example.taxipot_android.domain.entity.ChattingNotificate;

public class ChattingEntityMapper {
    public static ChattingEntity create(Pair<Integer,String> pair) {
        if(pair.second.equals("JOIN")) {
            return new ChattingNotificate("참가하였습니다.",pair.first + 1);
        } else if(pair.second.equals("REMOVE")) {
            return new ChattingNotificate("나가셨습니다.",pair.first + 1);
        }
        return new ChattingContent(pair.first + 1, pair.second);
    }
}

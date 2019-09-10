package com.example.taxipot_android.domain.entity;

import android.util.Log;
import android.view.View;

public class SettingContent {
    private String title;
    private String content;
    private View.OnClickListener listener;

    public SettingContent(String title, String content, View.OnClickListener listener) {
        this.title = title;
        this.content = content;
        this.listener = listener;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void onClick(View v) {
        Log.i("onClick","recyclerItem");
        listener.onClick(v);
    }
}

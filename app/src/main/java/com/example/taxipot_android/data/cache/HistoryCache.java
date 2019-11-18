package com.example.taxipot_android.data.cache;

import com.example.taxipot_android.domain.entity.History;

import java.util.List;

import io.reactivex.Single;

public class HistoryCache {
    private List<History> histories;
    private History history;

    public List<History> getHistories() {
        return histories;
    }

    public List<History> saveHistories(List<History> histories) {
        return this.histories = histories;
    }

    public Single<History> getHistory() {
        return Single.just(history);
    }

    public void setHistory(History history) {
        this.history = history;
    }
}

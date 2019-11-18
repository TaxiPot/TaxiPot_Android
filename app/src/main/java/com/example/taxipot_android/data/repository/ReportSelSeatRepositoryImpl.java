package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.cache.HistoryCache;
import com.example.taxipot_android.data.cache.ReportCache;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.domain.repository.ReportSelSeatRepository;

import io.reactivex.Single;

public class ReportSelSeatRepositoryImpl implements ReportSelSeatRepository {
    RemoteAPI api;
    HistoryCache historyCache;
    ReportCache reportCache;

    public ReportSelSeatRepositoryImpl(RemoteAPI api, HistoryCache historyCache, ReportCache reportCache) {
        this.api = api;
        this.historyCache = historyCache;
        this.reportCache = reportCache;
    }

    public Single<History> getHistory() {
        return historyCache.getHistory();
    }

    @Override
    public Single<String> saveReportUser(History history, Integer seatNum) {
        if(seatNum<0||seatNum>3) return Single.error(new ArrayIndexOutOfBoundsException("신고할 좌석을 선택해주세요."));
        String reportUser = reportCache.setReportId(history.getUserRoomId().getUserId());
        String reportedUser = reportCache.setReportedId(history.getSeatList().get(seatNum));
        return Single.just(reportUser + " " + reportedUser);
    }
}

package com.example.taxipot_android.data.remote;

import android.util.Log;

import com.example.taxipot_android.data.datasource.BugDataSource;
import com.example.taxipot_android.data.datasource.HistoryDataSource;
import com.example.taxipot_android.data.datasource.ReportDataSource;
import com.example.taxipot_android.data.datasource.TaxiPotDataSource;
import com.example.taxipot_android.data.datasource.UserDataSource;
import com.example.taxipot_android.domain.entity.Bug;
import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.domain.entity.Report;
import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.entity.User;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class RemoteAPIImpl implements RemoteAPI {
    UserDataSource userDS;
    TaxiPotDataSource taxiPotDS;
    ReportDataSource reportDS;
    HistoryDataSource historyDS;
    BugDataSource bugDS;

    public RemoteAPIImpl(UserDataSource userDS, TaxiPotDataSource taxiPotDS, ReportDataSource reportDS, HistoryDataSource historyDS, BugDataSource bugDS) {
        this.userDS = userDS;
        this.taxiPotDS = taxiPotDS;
        this.reportDS = reportDS;
        this.historyDS = historyDS;
        this.bugDS = bugDS;
    }

    @Override
    public Single<User> signIn(User user) {
        return userDS.signIn(user);
    }

    @Override
    public Single<User> signUp(User user) {
        return userDS.signUp(user);
    }

    @Override
    public Observable<User> changePassWord(String id, String fromPW, String toPW) {
        return userDS.changePassword(id,fromPW,toPW);
    }

    @Override
    public Single<TaxiPot> joinTaxiPot(int roomId, String userId, int seat_num) {
        return taxiPotDS.joinTaxiPot(roomId,userId,seat_num);
    }

    @Override
    public Observable<TaxiPot> findTaxipotList(TaxiPot taxiPot, float radius, int age) {
        return taxiPotDS.findTaxiPotList(taxiPot,radius,age);
    }

    @Override
    public Single<TaxiPot> makeTaxipot(TaxiPot taxiPot) {
        return taxiPotDS.makeTaxiPot(taxiPot);
    }

    @Override
    public Observable<Report> sendReport(Report report) {
        return reportDS.sendReport(report);
    }

    @Override
    public Observable<List<History>> findHistoryById(String userId) {
        Log.e(this.getClass().getSimpleName(),"findHistoryById" + userId);
        return historyDS.findHistoryById(userId);
    }

    @Override
    public Observable<Integer> sendHistoryList(String id, List<History> historyList) {
        return historyDS.sendHistoryList(id,historyList);
    }

    @Override
    public Single<Bug> postBug(Bug bug) {
        return bugDS.postBug(bug);
    }
}

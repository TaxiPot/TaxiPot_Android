package com.example.taxipot_android.data.remote;

import com.example.taxipot_android.domain.entity.Bug;
import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.domain.entity.Report;
import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.entity.User;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface RemoteAPI {
    Single<User> signIn(User user);

    Single<User> signUp(User user);

    Single<User> changePassWord(String id, String fromPW, String toPW);

    Single<TaxiPot> joinTaxiPot(int roomId, String userId, int seat_num);

    Observable<List<TaxiPot>> findTaxipotList(TaxiPot taxiPot,
                                              float radius,
                                              int age,
                                              boolean isMan);

    Single<TaxiPot> makeTaxipot(TaxiPot taxiPot);

    Observable<Report> sendReport(Report report);

    Observable<List<History>> findHistoryById(String userId);

    Observable<Integer> sendHistoryList(String id, List<History> historyList);

    Single<Bug> postBug(Bug bug);
}

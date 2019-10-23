package com.example.taxipot_android;

import com.example.taxipot_android.data.api.BugApi;
import com.example.taxipot_android.data.api.HistoryApi;
import com.example.taxipot_android.data.api.ReportApi;
import com.example.taxipot_android.data.api.TaxipotApi;
import com.example.taxipot_android.data.api.UserApi;
import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.util.CreateRetrofit;

import org.junit.Test;

import java.util.Calendar;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Predicate;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void dateFormat_isCorrect() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 8, 15, 13, 30);
        TaxiPot taxiPot = new TaxiPot(calendar, "출발지", "목적지");
        assertEquals(taxiPot.dateFormat(), "09/15 13:30");
        System.out.println(taxiPot.dateFormat());
    }

    @Test
    public void apiTestStarter() {

        apiTest1(createTaxipotApi().makeTaxipot(new TaxiPot()));
    }

    private <R>void apiTest1(Observable<R> api) {
        api
                .test()
                .assertNoErrors()
                .assertSubscribed()
                .assertValue(new Predicate<R>() {
                    @Override
                    public boolean test(R c) throws Exception {
                        System.out.println(c);
                        return true;
                    }
                });
    }

    private <R>void apiTest1(Single<R> api) {
        api
                .test()
                .assertNoErrors()
                .assertSubscribed()
                .assertValue(new Predicate<R>() {
                    @Override
                    public boolean test(R c) throws Exception {
                        System.out.println(c);
                        return true;
                    }
                });
    }

    private <C> C connect(Class<C> c) {
        return CreateRetrofit.createRetrofit(c);
    }

    private UserApi createUserApi() {
        return connect(UserApi.class);
    }

    private TaxipotApi createTaxipotApi() {
        return connect(TaxipotApi.class);
    }

    private HistoryApi createHistoryApi() {
        return connect(HistoryApi.class);
    }

    private ReportApi createReportApi() {
        return connect(ReportApi.class);
    }

    private BugApi createBugApi() {
        return connect(BugApi.class);
    }
}
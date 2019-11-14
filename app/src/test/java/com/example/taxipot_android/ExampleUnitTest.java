package com.example.taxipot_android;

import com.example.taxipot_android.data.api.BugApi;
import com.example.taxipot_android.data.api.HistoryApi;
import com.example.taxipot_android.data.api.ReportApi;
import com.example.taxipot_android.data.api.TaxipotApi;
import com.example.taxipot_android.data.api.UserApi;
import com.example.taxipot_android.data.datasource.UserDataSource;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.data.remote.RemoteAPIImpl;
import com.example.taxipot_android.data.repository.HistoryRepositoryImpl;
import com.example.taxipot_android.domain.entity.Bug;
import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.domain.entity.Report;
import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.usecase.HistoryUseCaseImpl;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
    public void historyTest() {
        new HistoryRepositoryImpl(new RemoteApiImpl()).getHistories("id3").subscribeWith(new DisposableObserver<List<History>>() {
            @Override
            public void onNext(List<History> histories) {
                System.out.println(histories);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Test
    public void apiTestStarter() {

        apiTest1(createHistoryApi().findHistoryById("id3"));
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

    class RemoteApiImpl implements RemoteAPI {
        @Override
        public Single<User> signIn(User user) {
            return null;
        }

        @Override
        public Single<User> signUp(User user) {
            return null;
        }

        @Override
        public Observable<User> changePassWord(String id, String fromPW, String toPW) {
            return null;
        }

        @Override
        public Single<TaxiPot> joinTaxiPot(int roomId, String userId, int seat_num) {
            return null;
        }

        @Override
        public Observable<TaxiPot> findTaxipotList(TaxiPot taxiPot, float radius, int age) {
            return null;
        }

        @Override
        public Single<TaxiPot> makeTaxipot(TaxiPot taxiPot) {
            return null;
        }

        @Override
        public Observable<Report> sendReport(Report report) {
            return null;
        }

        @Override
        public Observable<List<History>> findHistoryById(String userId) {
            return createHistoryApi().findHistoryById(userId);
        }

        @Override
        public Observable<Integer> sendHistoryList(String id, List<History> historyList) {
            return null;
        }

        @Override
        public Single<Bug> postBug(Bug bug) {
            return null;
        }
    }
}

class CreateRetrofit {
    private final static String baseUrl = "http://127.0.0.1:8080/";
    private final static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    public static <T> T createRetrofit(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}


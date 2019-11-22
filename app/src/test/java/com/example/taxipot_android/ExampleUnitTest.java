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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
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
        System.out.println(new Date(2019-1900,11-1,20,16,37).getMinutes());
        System.out.println(new Date().getMinutes());
        assertEquals(1,1);
    }

    @Test
    public void test1() {
        List<String> arr = new ArrayList<>();
        arr.add("asdf");
        arr.add("qwer");
        Observable.just(arr)
                .flatMapIterable(new Function<List<String>, Iterable<String>>() {
                    @Override
                    public Iterable<String> apply(List<String> strings) throws Exception {
                        return strings;
                    }
                })
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return s + "@";
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });
    }

    @Test
    public void apiTestStarter() {
        createHistoryApi().findHistoryById("id3")
                .flatMapIterable(new Function<List<History>, Iterable<History>>() {
                    @Override
                    public Iterable<History> apply(List<History> histories) throws Exception {
                        return histories;
                    }
                })
                .map(new Function<History, History>() {
                    @Override
                    public History apply(History history) throws Exception {
                        history.setStart("요기에옴");
                        return history;
                    }
                })
                .test()
                .assertNoErrors()
                .assertSubscribed()
                .assertValue(new Predicate<History>() {
                    @Override
                    public boolean test(History history) throws Exception {
                        System.out.println(history.getStart());
                        return true;
                    }
                });
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


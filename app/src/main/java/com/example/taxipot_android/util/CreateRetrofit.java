package com.example.taxipot_android.util;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateRetrofit {
    private final static String baseUrl = "http://10.0.2.2:8080/";
    private final static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    public static <T> T createRetrofit(Class<T> clazz) {
        Log.e(CreateRetrofit.class.getSimpleName(),clazz.getSimpleName());
        return retrofit.create(clazz);
    }
}


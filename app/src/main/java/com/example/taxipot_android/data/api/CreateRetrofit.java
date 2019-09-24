package com.example.taxipot_android.data.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateRetrofit {
    final static String BaseURL = "";
    final static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    public static <C> C createRetrofit(Class<C> clazz) {
        return retrofit.create(clazz);
    }
}

package com.example.taxipot_android.data.datasource;

import com.example.taxipot_android.data.api.BugApi;
import com.example.taxipot_android.domain.entity.Bug;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BugDataSource {
    private BugApi api;
    public BugDataSource(BugApi api) {
        this.api = api;
    }

    public Single<Bug> postBug(Bug bug) {
        return api.postBug(bug);
    }
}

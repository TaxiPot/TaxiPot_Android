package com.example.taxipot_android.data.datasource;

import com.example.taxipot_android.data.api.BugApi;
import com.example.taxipot_android.domain.entity.Bug;

import io.reactivex.Single;

public class BugDataSource {
    private BugApi api;
    public BugDataSource(BugApi api) {
        this.api = api;
    }

    public Single<Bug> postBug(Bug bug) {
        return api.postBug(bug);
    }
}

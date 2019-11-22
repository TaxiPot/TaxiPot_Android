package com.example.taxipot_android.data.repository;

import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.domain.entity.Bug;
import com.example.taxipot_android.domain.repository.BugReportRepository;

import io.reactivex.Single;

public class BugReportRepositoryImpl implements BugReportRepository {
    RemoteAPI api;
    Single<Bug> report(Bug bug) {
        return api.postBug(bug);
    }
}

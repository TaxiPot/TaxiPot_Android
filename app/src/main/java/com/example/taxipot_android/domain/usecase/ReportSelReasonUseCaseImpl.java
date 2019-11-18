package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.domain.entity.Report;
import com.example.taxipot_android.domain.repository.ReportSelReasonRepository;

import io.reactivex.observers.DisposableObserver;

public class ReportSelReasonUseCaseImpl extends ReportSelReasonUseCase<Report> {

    private ReportSelReasonRepository repository;

    public ReportSelReasonUseCaseImpl(ReportSelReasonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void doReport(int num, DisposableObserver disposable) {
        execute(repository.doReport(num),disposable);
    }
}

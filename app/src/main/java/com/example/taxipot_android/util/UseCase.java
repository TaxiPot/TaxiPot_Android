package com.example.taxipot_android.util;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase <T> {
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected void execute(Observable<T> observable, DisposableObserver disposable) {
        DisposableObserver observer = observable.observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeWith(disposable);
        addDisposable(observer);
    }

    protected void execute(Single<T> observable, DisposableSingleObserver disposable) {
        DisposableSingleObserver observer = observable.observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeWith(disposable);
        addDisposable(observer);
    }

    private void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    public void dispose() {
        compositeDisposable.dispose();
    }

}

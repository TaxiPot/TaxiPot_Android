package com.example.taxipot_android.util;

import android.util.Log;

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

    protected <T>void execute(Observable<T> observable, DisposableObserver disposable) {
        Log.e(this.getClass().getSimpleName(),"execute");
        DisposableObserver observer = observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(disposable);
        addDisposable(observer);
    }

    protected <T>void execute(Single<T> observable, DisposableSingleObserver disposable) {
        Log.e(this.getClass().getSimpleName(),"execute");
        DisposableSingleObserver observer = observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
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

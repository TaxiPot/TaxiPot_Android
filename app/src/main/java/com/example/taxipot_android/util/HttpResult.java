package com.example.taxipot_android.util;


import io.reactivex.functions.Consumer;

public class HttpResult<T> {
    public T result;
    public String message;

    public HttpResult(T result, String message) {
        this.result = result;
        this.message = message;
    }

    public HttpResult() {
    }
}

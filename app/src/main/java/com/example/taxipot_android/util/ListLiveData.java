package com.example.taxipot_android.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListLiveData<T> extends MutableLiveData<List<T>> {
    public ListLiveData() {
        setValue(new ArrayList<>());
    }
    public ListLiveData(List<T> list) {
        setValue(list);
    }

    public int size() {
        return getValue().size();
    }

    public boolean contains(@Nullable T o) {
        return getValue().contains(o);
    }

    public void add(T t) {
        List<T> list = getValue();
        list.add(t);
        postValue(list);
    }

    public void addAll(@NonNull Collection<? extends T> c) {
        List<T> list = getValue();
        list.addAll(c);
        postValue(list);
    }

    public void clear() {
        getValue().clear();
    }

    public T get(int index) {
        return getValue().get(index);
    }

    public void add(int index, T element) {
        List<T> list = getValue();
        list.add(index,element);
        postValue(list);
    }

    public T remove(int index) {
        List<T> list = getValue();
        T res = list.remove(index);
        postValue(list);
        return res;
    }
}

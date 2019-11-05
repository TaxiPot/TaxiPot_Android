package com.example.taxipot_android.presenter.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.repository.HistoryRepository;

import java.util.ArrayList;
import java.util.Calendar;

public class HistoryViewModel extends ViewModel {

    private HistoryRepository repository;
    private ArrayList<LiveData<TaxiPot>> taxipotList;

    public HistoryViewModel(HistoryRepository repository) {
        this.repository = repository;
    }

    public ArrayList<LiveData<TaxiPot>> getTaxipotList() {
        taxipotList = dummyData();
        return taxipotList;
    }

    private ArrayList<LiveData<TaxiPot>> dummyData() {
        ArrayList<LiveData<TaxiPot>> list = new ArrayList<>();
        list.add(new MutableLiveData(new TaxiPot(Calendar.getInstance(), "서울", "서울")));
        list.add(new MutableLiveData(new TaxiPot(Calendar.getInstance(), "서울", "서울")));
        list.add(new MutableLiveData(new TaxiPot(Calendar.getInstance(), "서울", "서울")));
        list.add(new MutableLiveData(new TaxiPot(Calendar.getInstance(), "서울", "서울")));
        list.add(new MutableLiveData(new TaxiPot(Calendar.getInstance(), "서울", "서울")));
        return list;
    }
}

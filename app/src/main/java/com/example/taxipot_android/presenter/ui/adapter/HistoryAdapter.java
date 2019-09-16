package com.example.taxipot_android.presenter.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ItemBreakdownHistoryBinding;
import com.example.taxipot_android.domain.entity.TaxiPot;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<LiveData<TaxiPot>> items;
    public HistoryAdapter(ArrayList<LiveData<TaxiPot>> list) {
        this.items = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBreakdownHistoryBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_breakdown_history,parent,false);
        return new HistoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HistoryViewHolder) {
            ((HistoryViewHolder) holder).bind(items.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        ItemBreakdownHistoryBinding binding;
        HistoryViewHolder(ItemBreakdownHistoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        void bind(LiveData<TaxiPot> item) {
            binding.setVh(this);
            binding.historyItemDepartTime.setText(item.getValue().dateFormat());
            binding.historyItemStartToFinish.setText(item.getValue().startToFinish());
        }
        public void onClick(View v) {
            Log.i("historyList","Click");
        }
    }
}

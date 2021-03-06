package com.example.taxipot_android.presenter.ui.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ItemBreakdownHistoryBinding;
import com.example.taxipot_android.domain.entity.History;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.ui.activity.ReportActivity;
import com.example.taxipot_android.presenter.viewModel.HistoryViewModel;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private BaseFragment activity;
    List<History> items;
    HistoryViewModel viewModel;
    public HistoryAdapter(BaseFragment activity, List<History> list, HistoryViewModel viewModel) {
        this.activity = activity;
        this.items = list;
        this.viewModel = viewModel;
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

    public void addItem(History history) {
        items.add(history);
        notifyItemInserted(items.size());
    }

    public void addItem(List<History> histories) {
        int size = items.size()-1;
        if(size==-1) size = 0;
        items.addAll(histories);
        notifyItemRangeChanged(size, histories.size());
    }

    public void replace(List<History> histories) {
        items = histories;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        ItemBreakdownHistoryBinding binding;
        History item;
        HistoryViewHolder(ItemBreakdownHistoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        void bind(History item) {
            this.item = item;
            binding.setVh(this);
            binding.historyItemDepartTime.setText(item.dateFormat());
            binding.historyItemStartToFinish.setText(item.startToFinish());
        }
        public void onClick(View v) {
            viewModel.reportOnHistory(item);
            activity.startActivity(new Intent(activity.getActivity(), ReportActivity.class));
        }
    }
}

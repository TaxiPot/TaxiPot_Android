package com.example.taxipot_android.presenter.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ItemReportReasonBinding;

import java.util.List;

public class ReportReasonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<String> reasonList;

    public ReportReasonAdapter(List<String> reasonList) {
        this.reasonList = reasonList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReportReasonViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_report_reason,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ReportReasonViewHolder)holder).bind(reasonList.get(position));
    }

    @Override
    public int getItemCount() {
        return logAndItemCount();
    }

    private int logAndItemCount() {
        Log.i("ItemSize", Integer.toString(reasonList.size()));
        return reasonList.size();
    }

    class ReportReasonViewHolder extends RecyclerView.ViewHolder {
        ItemReportReasonBinding binding;
        ReportReasonViewHolder(ItemReportReasonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        void bind(String item) {
            binding.reportReasonCheckreasonCb.setText(item);
        }
    }
}

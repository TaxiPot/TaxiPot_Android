package com.example.taxipot_android.presenter.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ItemReportReasonBinding;
import com.example.taxipot_android.presenter.viewModel.ReportSelReasonViewModel;

import java.util.List;

public class ReportReasonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<String> reasonList;
    ReportSelReasonViewModel viewModel;
    public ReportReasonAdapter.ReportReasonViewHolder uncheckSeat = null;

    public ReportReasonAdapter(List<String> reasonList, ReportSelReasonViewModel viewModel) {
        this.reasonList = reasonList;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReportReasonViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_report_reason,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ReportReasonViewHolder)holder).bind(reasonList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return logAndItemCount();
    }

    private int logAndItemCount() {
        Log.i("ItemSize", Integer.toString(reasonList.size()));
        return reasonList.size();
    }

    public class ReportReasonViewHolder extends RecyclerView.ViewHolder {
        ItemReportReasonBinding binding;
        int position;
        ReportReasonViewHolder(ItemReportReasonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        void bind(String item, int position) {
            binding.reportReasonCheckreasonCb.setText(item);
            binding.setVh(this);
            this.position = position;
        }

        public void check(View v) {
            if(uncheckSeat==this) {
                viewModel.getSelectPosition().postValue(-1);
                return;
            }
            viewModel.getSelectPosition().postValue(position);
            if(ReportReasonAdapter.this.uncheckSeat!=null) ReportReasonAdapter.this.uncheckSeat.binding.reportReasonCheckreasonCb.setChecked(false);
            ReportReasonAdapter.this.uncheckSeat = this;
        }

        public void unCheck() {
            Log.e(this.getClass().getSimpleName(),"uncheck");
        }
    }
}

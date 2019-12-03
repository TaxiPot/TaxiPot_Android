package com.example.taxipot_android.presenter.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.ItemChatChattingBinding;
import com.example.taxipot_android.databinding.ItemChatNotifyBinding;
import com.example.taxipot_android.domain.entity.ChattingContent;
import com.example.taxipot_android.domain.entity.ChattingEntity;
import com.example.taxipot_android.domain.entity.ChattingNotificate;
import com.example.taxipot_android.presenter.viewModel.ChattingViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ChattingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ChattingViewModel viewModel;

    List<ChattingEntity> chatting = new ArrayList<>();

    public ChattingAdapter(Context context, ChattingViewModel viewModel) {
        this.context = context;
        this.viewModel = viewModel;
    }

    private final static int CHATTINGVIEWHOLDER = 0;
    private final static int NOTIFICATEVIEWHOLDER = 1;

    @Override
    public int getItemViewType(int position) {
        if (chatting.get(position) instanceof ChattingContent) return CHATTINGVIEWHOLDER;
        return NOTIFICATEVIEWHOLDER;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == CHATTINGVIEWHOLDER)
            return new ChattingViewHolder(DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_chat_chatting, parent, false));
        return new NotificateViewHolder(DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_chat_notify, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ChattingViewHolder) {
            ((ChattingViewHolder)holder).bind(chatting.get(position));
            return;
        }
        ((NotificateViewHolder)holder).bind(chatting.get(position));
    }

    @Override
    public int getItemCount() {
        return chatting.size();
    }

    public void add(ChattingEntity chattingEntity) {
        chatting.add(chattingEntity);
    }

    private class ChattingViewHolder extends RecyclerView.ViewHolder {
        ItemChatChattingBinding binding;
        public ChattingViewHolder(@NonNull ItemChatChattingBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(ChattingEntity content) {
            binding.setData((ChattingContent)content);
            binding.setVm(viewModel);
        }
    }

    private class NotificateViewHolder extends RecyclerView.ViewHolder {
        ItemChatNotifyBinding binding;
        public NotificateViewHolder(@NonNull ItemChatNotifyBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(ChattingEntity content) {
            binding.setData((ChattingNotificate)content);
        }
    }
}

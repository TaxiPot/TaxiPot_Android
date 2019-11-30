package com.example.taxipot_android.presenter.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taxipot_android.R;
import com.example.taxipot_android.data.remote.WebSocketHandler;
import com.example.taxipot_android.databinding.ItemChatChattingBinding;
import com.example.taxipot_android.databinding.ItemChatNotifyBinding;
import com.example.taxipot_android.domain.entity.ChattingContent;
import com.example.taxipot_android.domain.entity.ChattingEntity;

import java.util.ArrayList;
import java.util.List;

public class ChattingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    List<ChattingEntity> chatting = new ArrayList<>();

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

    }

    @Override
    public int getItemCount() {
        return chatting.size();
    }

    public void add(ChattingEntity chattingEntity) {
        chatting.add(chattingEntity);
    }

    private class ChattingViewHolder extends RecyclerView.ViewHolder {
        public ChattingViewHolder(@NonNull ItemChatChattingBinding itemView) {
            super(itemView.getRoot());
        }
    }

    private class NotificateViewHolder extends RecyclerView.ViewHolder {
        public NotificateViewHolder(@NonNull ItemChatNotifyBinding itemView) {
            super(itemView.getRoot());
        }
    }
}

package com.improve10x.crud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesViewHolder> {
    public List<Message> messageList;
    public onItemActionClickListener onItemActionClickListener;

    public void setData(List<Message> messages) {
        messageList = messages;
        notifyDataSetChanged();
    }
    public void setOnItemActionClickListener(onItemActionClickListener actionClickListener) {
        onItemActionClickListener = actionClickListener;
    }
    @NonNull
    @Override
    public MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_item, parent, false);
        MessagesViewHolder messagesViewHolder = new MessagesViewHolder(view);
        return messagesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesViewHolder holder, int position) {
        Message message = messageList.get(position);
        holder.nameTxt.setText(message.name);
        holder.phoneNumberTxt.setText(message.phoneNumber);
        holder.messageTextTxt.setText(message.messageText);
        holder.deleteBtn.setOnClickListener(view -> {
            onItemActionClickListener.onDelete(message.id);
        });

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}

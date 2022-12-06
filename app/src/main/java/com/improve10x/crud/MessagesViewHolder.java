package com.improve10x.crud;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MessagesViewHolder extends RecyclerView.ViewHolder {
    public TextView nameTxt;
    public TextView phoneNumberTxt;
    public TextView messageTextTxt;
    public ImageButton deleteBtn;
    public MessagesViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTxt = itemView.findViewById(R.id.name_txt);
        phoneNumberTxt = itemView.findViewById(R.id.phonenumber_txt);
        messageTextTxt = itemView.findViewById(R.id.messagetext_txt);
        deleteBtn = itemView.findViewById(R.id.delete_btn);
    }
}

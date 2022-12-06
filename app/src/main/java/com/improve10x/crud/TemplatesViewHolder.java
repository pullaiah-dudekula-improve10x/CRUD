package com.improve10x.crud;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TemplatesViewHolder extends RecyclerView.ViewHolder {
    public TextView messagesTextTxt;
    public ImageButton deleteBtn;
    public TemplatesViewHolder(@NonNull View itemView) {
        super(itemView);
        messagesTextTxt = itemView.findViewById(R.id.message_text_txt1);
        deleteBtn = itemView.findViewById(R.id.delete_btn);
    }
}

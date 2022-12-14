package com.improve10x.crud.template;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

public class TemplatesViewHolder extends RecyclerView.ViewHolder {

     TextView messageTextTxt;
     ImageButton deleteBtn;

    public TemplatesViewHolder(@NonNull View itemView) {
        super(itemView);
        messageTextTxt = itemView.findViewById(R.id.message_text_txt1);
        deleteBtn = itemView.findViewById(R.id.delete_btn);
    }
}

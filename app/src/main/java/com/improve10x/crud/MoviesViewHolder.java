package com.improve10x.crud;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesViewHolder extends RecyclerView.ViewHolder {
    ImageView imageImg;
    ImageButton deleteBtn;
    TextView titleTxt;
    public MoviesViewHolder(@NonNull View itemView) {
        super(itemView);
        imageImg = itemView.findViewById(R.id.image_img);
        deleteBtn = itemView.findViewById(R.id.delete_btn);
        titleTxt = itemView.findViewById(R.id.title_txt);
    }
}

package com.improve10x.crud.movies;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

public class MoviesViewHolder extends RecyclerView.ViewHolder {

    ImageView moviesImg;
    ImageButton deleteBtn;
    TextView moviesTxt;
    public MoviesViewHolder(@NonNull View itemView) {
        super(itemView);
        //change the id names
        moviesImg = itemView.findViewById(R.id.image_img);
        deleteBtn = itemView.findViewById(R.id.delete_btn);
        moviesTxt = itemView.findViewById(R.id.title_text_txt);
    }
}

package com.improve10x.crud.movies;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

public class MoviesViewHolder extends RecyclerView.ViewHolder {

    ImageView movieImg;
    ImageButton deleteBtn;
    TextView moviesTextTxt;
    public MoviesViewHolder(@NonNull View itemView) {
        super(itemView);
        movieImg = itemView.findViewById(R.id.movie_img);
        deleteBtn = itemView.findViewById(R.id.delete_btn);
        moviesTextTxt = itemView.findViewById(R.id.title_text_txt);
    }
}

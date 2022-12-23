package com.improve10x.crud.movies;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;
import com.improve10x.crud.databinding.MoviesItemBinding;

public class MoviesViewHolder extends RecyclerView.ViewHolder {

    MoviesItemBinding binding;
    public MoviesViewHolder(MoviesItemBinding moviesItemBinding) {
        super(moviesItemBinding.getRoot());
        binding = moviesItemBinding;
    }
}

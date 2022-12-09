package com.improve10x.crud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.series.OnItemActionClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder> {
    private List<Movie> movies;
    public OnItemActionClickListener onItemActionClickListener;

    public void setData(List<Movie> movieList) {
        movies = movieList;
        notifyDataSetChanged();
    }
    public  void setOnItemActionListener(OnItemActionClickListener actionListener) {
        onItemActionClickListener = actionListener;
    }
    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_item, parent, false);
        MoviesViewHolder moviesViewHolder = new MoviesViewHolder(view);
        return moviesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        Movie movie = movies.get(position);
        Picasso.get().load(movie.imageUrl).into(holder.imageImg);
        holder.titleTxt.setText(movie.name);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
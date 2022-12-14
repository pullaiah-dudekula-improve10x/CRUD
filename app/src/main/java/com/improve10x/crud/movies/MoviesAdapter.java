package com.improve10x.crud.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder> {

    private List<Movie> movie;
    private OnItemActionClickListener onItemActionClickListener;
// todo ; declare modifier as default
     public void setData(List<Movie> movieList) {
        movie = movieList;
        notifyDataSetChanged();
    }

    void setOnItemActionClickListener(OnItemActionClickListener actionClickListener) {
        onItemActionClickListener = actionClickListener;
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
        Movie movie = this.movie.get(position);
        Picasso.get().load(movie.imageUrl).into(holder.moviesImg);
        holder.moviesTextTxt.setText(movie.movieName);
        holder.deleteBtn.setOnClickListener(view -> {
            onItemActionClickListener.onDelete(movie.id);
        });
        holder.itemView.setOnClickListener(view -> {
            onItemActionClickListener.onEdit(movie);
        });
    }

    @Override
    public int getItemCount() {
        return movie.size();
    }
}

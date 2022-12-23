package com.improve10x.crud.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;
import com.improve10x.crud.databinding.MoviesItemBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder> {

    private List<Movie> movie;
    private OnItemActionClickListener onItemActionClickListener;

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
        MoviesItemBinding binding = MoviesItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        MoviesViewHolder moviesViewHolder = new MoviesViewHolder(binding);
        return moviesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        Movie movie = this.movie.get(position);
        Picasso.get().load(movie.imageUrl).into(holder.binding.movieImg);
        holder.binding.titleTextTxt.setText(movie.movieName);
        holder.binding.deleteBtn.setOnClickListener(view -> {
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

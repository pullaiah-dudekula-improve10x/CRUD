package com.improve10x.crud.series;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesViewHolder> {

    private List<Series> seriesList;
    public OnItemActionClickListener onItemActionClickListener;

    public void setData(List<Series> series) {
        seriesList = series;
        notifyDataSetChanged();
    }

    public void setOnItemActionClickListener(OnItemActionClickListener actionClickListener) {
        onItemActionClickListener = actionClickListener;
    }

    @NonNull
    @Override
    public SeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.series_item, parent, false);
        SeriesViewHolder seriesViewHolder = new SeriesViewHolder(view);
        return seriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder holder, int position) {
        Series series = seriesList.get(position);
        Picasso.get().load(series.imageUrl).into(holder.imageImg);
        holder.titleTxt.setText(series.title);
        holder.seriesDeleteBtn.setOnClickListener(view -> {
            onItemActionClickListener.onDelete(series.id);
        });
        holder.itemView.setOnClickListener(view -> {
            onItemActionClickListener.onEdit(series);
        });
    }

    @Override
    public int getItemCount() {
        return seriesList.size();
    }
}

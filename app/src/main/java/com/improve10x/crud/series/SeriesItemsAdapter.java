package com.improve10x.crud.series;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SeriesItemsAdapter extends RecyclerView.Adapter<SeriesViewHolder> {

    private List<SeriesItem> seriesList;
    public  OnItemActionClickListener onItemActionClickListener;

    void setData(List<SeriesItem> series) {
        seriesList = series;
        notifyDataSetChanged();
    }

    void setOnItemActionClickListener(OnItemActionClickListener actionClickListener) {
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
        SeriesItem series = seriesList.get(position);
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

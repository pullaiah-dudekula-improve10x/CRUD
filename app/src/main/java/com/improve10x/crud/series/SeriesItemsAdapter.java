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

    private List<SeriesItem> seriesItems;
    public  OnItemActionClickListener onItemActionClickListener;

    void setData(List<SeriesItem> seriesItems) {
        this.seriesItems = seriesItems;
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
        SeriesItem seriesItem = seriesItems.get(position);
        Picasso.get().load(seriesItem.imageUrl).into(holder.seriesItemImg);
        holder.titleTxt.setText(seriesItem.title);
        holder.seriesDeleteBtn.setOnClickListener(view -> {
            onItemActionClickListener.onDelete(seriesItem.id);
        });
        holder.itemView.setOnClickListener(view -> {
            onItemActionClickListener.onEdit(seriesItem);
        });
    }

    @Override
    public int getItemCount() {
        return seriesItems.size();
    }
}

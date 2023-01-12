package com.improve10x.crud.series;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;
import com.improve10x.crud.databinding.SeriesItemBinding;
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
        SeriesItemBinding binding = SeriesItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        SeriesViewHolder seriesViewHolder = new SeriesViewHolder(binding);
        return seriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder holder, int position) {
        SeriesItem seriesItem = seriesItems.get(position);
        holder.binding.setSeriesItem(seriesItem);
        //Picasso.get().load(seriesItem.imageUrl).into(holder.binding.seriesItemImg);
        //holder.binding.titleTextTxt.setText(seriesItem.title);
        holder.binding.seriesDeleteBtn.setOnClickListener(view -> {
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

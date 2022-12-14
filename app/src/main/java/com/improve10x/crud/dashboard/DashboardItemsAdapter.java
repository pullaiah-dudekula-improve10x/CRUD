package com.improve10x.crud.dashboard;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.databinding.DashboardItemBinding;
import com.improve10x.crud.movies.MoviesActivity;
import com.improve10x.crud.series.SeriesItemsActivity;
import com.improve10x.crud.template.TemplatesActivity;
import com.improve10x.crud.messages.MessagesActivity;
import com.improve10x.crud.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DashboardItemsAdapter extends RecyclerView.Adapter<DashboardItemViewHolder> {

    private ArrayList<DashboardItem> dashboardItems;

    public void setData(ArrayList<DashboardItem> dashboardList) {
        dashboardItems = dashboardList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DashboardItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DashboardItemBinding binding = DashboardItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        DashboardItemViewHolder dashboardViewHolder = new DashboardItemViewHolder(binding);
        return dashboardViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardItemViewHolder holder, int position) {
        DashboardItem dashboard = dashboardItems.get(position);
        Picasso.get().load(dashboard.imageUrl).into(holder.binding.dashboardItemImg);
        holder.binding.titleTextTxt.setText(dashboard.title);
        holder.itemView.setOnClickListener(view -> {
             if(holder.binding.titleTextTxt.getText().toString().equalsIgnoreCase("Messages")) {
                 Intent intent = new Intent(holder.itemView.getContext(), MessagesActivity.class );
                 holder.itemView.getContext().startActivity(intent);
             } else if (holder.binding.titleTextTxt.getText().toString().equalsIgnoreCase("Templates")) {
                 Intent intent = new Intent(holder.itemView.getContext(), TemplatesActivity.class);
                 holder.itemView.getContext().startActivity(intent);
             } else if(holder.binding.titleTextTxt.getText().toString().equalsIgnoreCase("Series")) {
                 Intent intent = new Intent(holder.itemView.getContext(), SeriesItemsActivity.class);
                 holder.itemView.getContext().startActivity(intent);
             } else if (holder.binding.titleTextTxt.getText().toString().equalsIgnoreCase("Movies")) {
                 Intent intent = new Intent(holder.itemView.getContext(), MoviesActivity.class );
                 holder.itemView.getContext().startActivity(intent);
             }
        });
    }

    @Override
    public int getItemCount() {
        return dashboardItems.size();
    }
}

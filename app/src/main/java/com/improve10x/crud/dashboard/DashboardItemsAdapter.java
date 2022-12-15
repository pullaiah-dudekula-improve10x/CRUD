package com.improve10x.crud.dashboard;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.movies.MoviesActivity;
import com.improve10x.crud.series.SeriesListActivity;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_item, parent, false);
        DashboardItemViewHolder dashboardViewHolder = new DashboardItemViewHolder(view);
        return dashboardViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardItemViewHolder holder, int position) {
        DashboardItem dashboard = dashboardItems.get(position);
        Picasso.get().load(dashboard.imageUrl).into(holder.dashboardImageImg);
        holder.titleTxt.setText(dashboard.title);
        holder.itemView.setOnClickListener(view -> {
             if(holder.titleTxt.getText().toString().equalsIgnoreCase("Messages")) {
                 Intent intent = new Intent(holder.itemView.getContext(), MessagesActivity.class );
                 holder.itemView.getContext().startActivity(intent);
             } else if (holder.titleTxt.getText().toString().equalsIgnoreCase("Templates")) {
                 Intent intent = new Intent(holder.itemView.getContext(), TemplatesActivity.class);
                 holder.itemView.getContext().startActivity(intent);
             } else if(holder.titleTxt.getText().toString().equalsIgnoreCase("Series")) {
                 Intent intent = new Intent(holder.itemView.getContext(), SeriesListActivity.class);
                 holder.itemView.getContext().startActivity(intent);
             } else if (holder.titleTxt.getText().toString().equalsIgnoreCase("Movies")) {
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

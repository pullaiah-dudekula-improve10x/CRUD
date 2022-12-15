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
// todo; change class name dashboard adapter dashboardItems adapter
public class DashboardAdapter extends RecyclerView.Adapter<DashboardViewHolder> {

    private ArrayList<DashboardItem> dashboardItems;

    public void setData(ArrayList<DashboardItem> dashboardList) {
        dashboardItems = dashboardList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_item, parent, false);
        DashboardViewHolder dashboardViewHolder = new DashboardViewHolder(view);
        return dashboardViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {
        DashboardItem dashboard = dashboardItems.get(position);
        Picasso.get().load(dashboard.imageUrl).into(holder.imageImg);
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

package com.improve10x.crud.dashboard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

public class DashboardItemViewHolder extends RecyclerView.ViewHolder {

     ImageView dashboardItemImg;
     TextView titleTxt;

    public DashboardItemViewHolder(@NonNull View itemView) {
        super(itemView);
        dashboardItemImg = itemView.findViewById(R.id.dashboard_item_img);
        titleTxt = itemView.findViewById(R.id.title_text_txt);
    }
}

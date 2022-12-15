package com.improve10x.crud.dashboard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

public class DashboardItemViewHolder extends RecyclerView.ViewHolder {
//todo ; change imageImg to dashboardImg
     ImageView dashboardImageImg;
     TextView titleTxt;

    public DashboardItemViewHolder(@NonNull View itemView) {
        super(itemView);
        dashboardImageImg = itemView.findViewById(R.id.dashboard_image_img);
        titleTxt = itemView.findViewById(R.id.title_text_txt);
    }
}

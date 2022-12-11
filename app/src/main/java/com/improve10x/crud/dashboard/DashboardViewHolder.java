package com.improve10x.crud.dashboard;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

public class DashboardViewHolder extends RecyclerView.ViewHolder {
     ImageView imageImg;
     TextView titleTxt;
     LinearLayout dashboardLayout;
    public DashboardViewHolder(@NonNull View itemView) {
        super(itemView);
        imageImg = itemView.findViewById(R.id.image_img);
        titleTxt = itemView.findViewById(R.id.title_text_txt);
        dashboardLayout = itemView.findViewById(R.id.dashboardlayout);
    }
}

package com.improve10x.crud.dashboard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

public class DashboardViewHolder extends RecyclerView.ViewHolder {
//todo ; change imageImg to dashboardImg
     ImageView imageImg;
     TextView titleTxt;

    public DashboardViewHolder(@NonNull View itemView) {
        super(itemView);
        imageImg = itemView.findViewById(R.id.movies_img);
        titleTxt = itemView.findViewById(R.id.title_text_txt);
    }
}

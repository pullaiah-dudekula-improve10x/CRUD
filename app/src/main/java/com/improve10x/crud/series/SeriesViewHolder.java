package com.improve10x.crud.series;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

public class SeriesViewHolder extends RecyclerView.ViewHolder {

     ImageView imageImg;
     TextView titleTxt;
     ImageButton seriesDeleteBtn;

    public SeriesViewHolder(@NonNull View itemView) {
        super(itemView);
        // todo ; change object to seriesImg and seriesTxt
        imageImg = itemView.findViewById(R.id.dashboard_image_img);
        titleTxt = itemView.findViewById(R.id.title_text_txt);
        seriesDeleteBtn = itemView.findViewById(R.id.series_delete_btn);
    }
}

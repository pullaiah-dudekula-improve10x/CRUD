package com.improve10x.crud.movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.improve10x.crud.R;
import com.improve10x.crud.series.SeriesItem;

import java.util.List;

public class CustomSeriesAdapter extends ArrayAdapter<SeriesItem> {

    public CustomSeriesAdapter(@NonNull Context context, int resource, @NonNull List<SeriesItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.series_drop_down,parent, false);
        SeriesItem series = getItem(position);
        TextView titleTextTxt = view.findViewById(R.id.title_text_txt);
        titleTextTxt.setText(series.seriesId + " - " + series.title);
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.series_drop_down, parent, false);
        SeriesItem series = getItem(position);
        TextView titleTextTxt = view.findViewById(R.id.title_text_txt);
        titleTextTxt.setText(series.seriesId + " - " + series.title);
        return view;
    }
}


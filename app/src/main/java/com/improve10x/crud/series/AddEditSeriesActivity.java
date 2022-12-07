package com.improve10x.crud.series;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.improve10x.crud.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditSeriesActivity extends AppCompatActivity {
    private EditText seriesIdTxt;
    private EditText seriesNameTxt;
    private EditText imageUrlTxt;
    private Series series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_series);
        initView();
    }

    private void initView() {
        seriesIdTxt = findViewById(R.id.seriesid_txt);
        seriesNameTxt = findViewById(R.id.seriesname_txt);
        imageUrlTxt = findViewById(R.id.imageurl_txt);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_edit_series_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.edit) {
            String seriesId = seriesIdTxt.getText().toString();
            String name = seriesNameTxt.getText().toString();
            String imageUrl = imageUrlTxt.getText().toString();
            addSeries(seriesId, name, imageUrl);
            if(series == null) {
                addSeries(seriesId, name, imageUrl);

            } else {

            }
            return true;
        } else {
            return  super.onOptionsItemSelected(item);
        }
    }

    private void addSeries (String seriesId, String seriesName, String imageUrl) {
        series = new Series();
        series.seriesId = seriesId;
        series.title = seriesName;
        series.imageUrl = imageUrl;

        SeriesApi seriesApi = new SeriesApi();
        SeriesService seriesService = seriesApi.createSeriesService();
        Call<Series> call = seriesService.createSeries(series);
        call.enqueue(new Callback<Series>() {
            @Override
            public void onResponse(Call<Series> call, Response<Series> response) {
                Toast.makeText(AddEditSeriesActivity.this, "Successfully added the series", Toast.LENGTH_SHORT).show();
                finish();

            }

            @Override
            public void onFailure(Call<Series> call, Throwable t) {
                Toast.makeText(AddEditSeriesActivity.this, "Failed to load Series", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
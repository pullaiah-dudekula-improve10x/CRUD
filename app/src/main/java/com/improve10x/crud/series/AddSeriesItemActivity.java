package com.improve10x.crud.series;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.improve10x.crud.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class AddSeriesItemActivity extends BaseAddEditSeriesItemsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Series");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.save) {
            String seriesId = seriesIdTxt.getText().toString();
            String name = seriesNameTxt.getText().toString();
            String imageUrl = imageUrlTxt.getText().toString();
            addSeriesItem(seriesId, name, imageUrl);
            return true;
        } else {
            return  super.onOptionsItemSelected(item);
        }
    }

    private void addSeriesItem(String seriesId, String seriesName, String imageUrl) {
        SeriesItem series = new SeriesItem();
        series.seriesId = seriesId;
        series.title = seriesName;
        series.imageUrl = imageUrl;
        Call<SeriesItem> call = crudService.createSeriesItem(series);
        call.enqueue(new Callback<SeriesItem>() {
            @Override
            public void onResponse(Call<SeriesItem> call, Response<SeriesItem> response) {
                showToast("Successfully added the series");
                finish();
            }

            @Override
            public void onFailure(Call<SeriesItem> call, Throwable t) {
                showToast("Failed to add the series");
            }
        });
    }
}

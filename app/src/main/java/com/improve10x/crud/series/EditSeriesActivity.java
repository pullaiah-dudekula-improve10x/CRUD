package com.improve10x.crud.series;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.improve10x.crud.Constants;
import com.improve10x.crud.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditSeriesActivity extends BaseAddEditSeriesItemsActivity {
    // todo ; change class EditSeriesActivity to EditSeriesItemActivity
    private Series series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().hasExtra(Constants.KEY_SERIES)) {
            getSupportActionBar().setTitle("Edit Series");
            series = (Series) getIntent().getSerializableExtra(Constants.KEY_SERIES);
            showMessage();
        }
    }

    private void showMessage() {
        seriesIdTxt.setText(series.seriesId);
        seriesNameTxt.setText(series.title);
        imageUrlTxt.setText(series.imageUrl);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.save) {
            String seriesId = seriesIdTxt.getText().toString();
            String name = seriesNameTxt.getText().toString();
            String imageUrl = imageUrlTxt.getText().toString();

            updateSeries(series.id, seriesId, name, imageUrl);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
    // todo ; change method name  updateSeries to  updateSeriesItem
    private void updateSeries(String id, String seriesId, String seriesName, String imageUrl) {
        series = new Series();
        series.seriesId = seriesId;
        series.title = seriesName;
        series.imageUrl = imageUrl;
        Call<Void> call = crudService.updateSeriesItem(id, series);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Successfully update the series");
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed to update the series");
            }
        });
    }
}


package com.improve10x.crud.series;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.improve10x.crud.Constants;
import com.improve10x.crud.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditSeriesItemActivity extends BaseAddEditSeriesItemsActivity {

    private SeriesItem seriesItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().hasExtra(Constants.KEY_SERIES)) {
            getSupportActionBar().setTitle("Edit Series");
            seriesItem = (SeriesItem) getIntent().getSerializableExtra(Constants.KEY_SERIES);
            showMessage();
        }
    }

    private void showMessage() {
        seriesIdTxt.setText(seriesItem.seriesId);
        seriesNameTxt.setText(seriesItem.title);
        imageUrlTxt.setText(seriesItem.imageUrl);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.save) {
            String seriesId = seriesIdTxt.getText().toString();
            String name = seriesNameTxt.getText().toString();
            String imageUrl = imageUrlTxt.getText().toString();

            updateSeriesItem(seriesItem.id, seriesId, name, imageUrl);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void updateSeriesItem(String id, String seriesId, String seriesName, String imageUrl) {
        seriesItem = new SeriesItem();
        seriesItem.seriesId = seriesId;
        seriesItem.title = seriesName;
        seriesItem.imageUrl = imageUrl;
        Call<Void> call = crudService.updateSeriesItem(id, seriesItem);
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

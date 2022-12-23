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
        binding.seriesidTxt.setText(seriesItem.seriesId);
        binding.seriesnameTxt.setText(seriesItem.title);
        binding.imageurlTxt.setText(seriesItem.imageUrl);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.save) {
            String seriesId = binding.seriesidTxt.getText().toString();
            String name = binding.seriesnameTxt.getText().toString();
            String imageUrl = binding.imageurlTxt.getText().toString();

            updateSeriesItem(seriesItem.id, seriesId, name, imageUrl);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void updateSeriesItem(String id, String seriesId, String seriesName, String imageUrl) {
       SeriesItem updatedSeriesItem = new SeriesItem();
        updatedSeriesItem.seriesId = seriesId;
        updatedSeriesItem.title = seriesName;
        updatedSeriesItem.imageUrl = imageUrl;
        Call<Void> call = crudService.updateSeriesItem(id, updatedSeriesItem);
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


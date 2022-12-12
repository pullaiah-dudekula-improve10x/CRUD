package com.improve10x.crud.series;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.improve10x.crud.Constants;
import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;
import com.improve10x.crud.network.CrudApi;
import com.improve10x.crud.network.CrudService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditSeriesActivity extends BaseActivity {
    private EditText seriesIdTxt;
    private EditText seriesNameTxt;
    private EditText imageUrlTxt;
    private Series series;
    private CrudService crudService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_series);
        setUpApiService();
        initView();
        if(getIntent().hasExtra(Constants.KEY_SERIES)) {
            getSupportActionBar().setTitle("Edit Series");
           series = (Series) getIntent().getSerializableExtra(Constants.KEY_SERIES);
           showData();

        } else {
            getSupportActionBar().setTitle("Add Series");
        }
    }

    private void setUpApiService() {
        CrudApi crudApi = new CrudApi();
        crudService = crudApi.createCrudService();
    }

    private void initView() {
        seriesIdTxt = findViewById(R.id.seriesid_txt);
        seriesNameTxt = findViewById(R.id.seriesname_txt);
        imageUrlTxt = findViewById(R.id.imageurl_txt);
    }

    private void showData() {
        seriesIdTxt.setText(series.seriesId);
        seriesNameTxt.setText(series.title);
        imageUrlTxt.setText(series.imageUrl);
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
                updateSeries(series.id, seriesId, name, imageUrl);

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

        Call<Series> call = crudService.createSeries(series);
        call.enqueue(new Callback<Series>() {
            @Override
            public void onResponse(Call<Series> call, Response<Series> response) {
               showToast("Successfully added the series");
                finish();

            }

            @Override
            public void onFailure(Call<Series> call, Throwable t) {
               showToast("Failed to add the series");

            }
        });
    }
    private void updateSeries(String id, String seriesId, String seriesName, String imageUrl) {
        series = new Series();
        series.seriesId = seriesId;
        series.title = seriesName;
        series.imageUrl = imageUrl;

        Call<Void> call = crudService.editSeries(id, series);
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
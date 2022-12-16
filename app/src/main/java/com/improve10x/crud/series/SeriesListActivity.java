package com.improve10x.crud.series;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.improve10x.crud.Constants;
import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesListActivity extends BaseActivity {
// todo ; change object series to seriesItems
    private ArrayList<Series> series = new ArrayList<>();
    private RecyclerView seriesRv;
    private SeriesAdapter seriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);
        getSupportActionBar().setTitle("Series List");
        log("onCreate");
        setUpSeriesRv();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.series_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add) {
            Intent intent = new Intent(this, AddSeriesItemActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchSeries();
        log("onResume");
    }
    // todo ; change  method name editSeries to editSeries item
    private void editSeries(Series series) {
        Intent intent = new Intent(this, EditSeriesItemActivity.class);
        intent.putExtra(Constants.KEY_SERIES, series);
        startActivity(intent);
    }
// todo ; change method  name setupSeriesRv to seriesListRv
    private void setUpSeriesRv() {
        seriesRv = findViewById(R.id.series_rv);
        seriesRv.setLayoutManager(new LinearLayoutManager(this));
        seriesAdapter = new SeriesAdapter();
        seriesAdapter.setData(series);
        seriesAdapter.setOnItemActionClickListener(new OnItemActionClickListener() {
            @Override
            public void onDelete(String id) {
                deleteSeries(id);
            }

            @Override
            public void onEdit(Series series) {
                editSeries(series);
            }
        });
        seriesRv.setAdapter(seriesAdapter);
    }
// todo ; change  method names fetchSeries to seriesItems
    private void fetchSeries() {
        Call<List<Series>> call = crudService.fetchSeriesItems();
        call.enqueue(new Callback<List<Series>>() {
            @Override
            public void onResponse(Call<List<Series>> call, Response<List<Series>> response) {
                List<Series> series = response.body();
                seriesAdapter.setData(series);
            }

            @Override
            public void onFailure(Call<List<Series>> call, Throwable t) {
                showToast("Failed to fetch Series");
            }
        });

    }
    // todo ; change method delete series to delete series item
    private void deleteSeries(String id) {
        Call<Void> call = crudService.deleteSeriesItem(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Successfully delete the series");
                fetchSeries();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Successfully delete the series");
            }
        });
    }
}
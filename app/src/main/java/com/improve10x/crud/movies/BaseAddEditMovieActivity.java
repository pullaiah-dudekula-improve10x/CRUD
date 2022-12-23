package com.improve10x.crud.movies;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Spinner;

import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;
import com.improve10x.crud.databinding.ActivityAddEditMovieBinding;
import com.improve10x.crud.series.SeriesItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseAddEditMovieActivity extends BaseActivity {

    protected ActivityAddEditMovieBinding binding;
    protected CustomSeriesAdapter customSeriesAdapter;
    protected ArrayList<SeriesItem> seriesList = new ArrayList<>();
    protected Movie movie;
    protected Spinner seriesSp;
    protected SeriesItem series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddEditMovieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupSeriesItemsSp();
        log("onCreate");
        fetchSeriesItems();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_edit_movies, menu);
        return true;
    }

    private void fetchSeriesItems() {
        Call<List<SeriesItem>> call = crudService.fetchSeriesItems();
        call.enqueue(new Callback<List<SeriesItem>>() {
            @Override
            public void onResponse(Call<List<SeriesItem>> call, Response<List<SeriesItem>> response) {
                List<SeriesItem> seriesList1 = response.body();
                customSeriesAdapter.addAll(seriesList1);
                if(movie != null) {
                    showData();
                }
            }
            @Override
            public void onFailure(Call<List<SeriesItem>> call, Throwable t) {

            }
        });
    }

    private void setupSeriesItemsSp() {
        customSeriesAdapter = new CustomSeriesAdapter(this, android.R.layout.simple_list_item_1, seriesList);
        binding.seriesSp.setAdapter(customSeriesAdapter);
    }

    protected void showData() {
        binding.movieIdTxt.setText(movie.movieId);
        binding.movieNameTxt.setText(movie.movieName);
        binding.movieImageurlTxt.setText(movie.imageUrl);;
        binding.descriptionTxt.setText(movie.description);
        for (int i = 0; i<customSeriesAdapter.getCount(); i++) {
            series = customSeriesAdapter.getItem(i);
            if(movie.seriesId.equals(series.seriesId)) {
                seriesSp.setSelection(i);
            }
        }
    }
}
package com.improve10x.crud.movies;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Spinner;

import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;
import com.improve10x.crud.series.Series;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseAddEditMovieActivity extends BaseActivity {

    protected CustomSeriesAdapter customSeriesAdapter;
    protected ArrayList<Series> seriesList = new ArrayList<>();
    protected Movie movie;
    protected EditText movieIdTxt;
    protected EditText movieNameTxt;
    protected EditText movieImageUrlTxt;
    protected EditText movieDescriptionTxt;
    protected Spinner seriesSp;
    protected Series series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_movie);
        //todo ; change initValue to initViews
        initValue();
        // todo ; here change name to setupSeriesListSp
        setUpSeriesSp();
        log("onCreate");
        // todo ; here change name to fetchSeriesList
        fetchSeries();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_edit_movies, menu);
        return true;
    }

    private void fetchSeries() {
        Call<List<Series>> call = crudService.fetchSeriesItems();
        call.enqueue(new Callback<List<Series>>() {
            @Override
            public void onResponse(Call<List<Series>> call, Response<List<Series>> response) {
                List<Series> seriesList1 = response.body();
                customSeriesAdapter.addAll(seriesList1);
                if(movie != null) {
                    showData();
                }
            }
            @Override
            public void onFailure(Call<List<Series>> call, Throwable t) {

            }
        });
    }
// todo ; here change name initValue to initViews
    private void initValue() {
        seriesSp = findViewById(R.id.series_sp);
        movieIdTxt = findViewById(R.id.movie_id_txt);
        movieNameTxt = findViewById(R.id.movie_name_txt);
        movieImageUrlTxt = findViewById(R.id.movie_imageurl_txt);
        movieDescriptionTxt = findViewById(R.id.description_txt);
    }

    private void setUpSeriesSp() {
        customSeriesAdapter = new CustomSeriesAdapter(this, android.R.layout.simple_list_item_1, seriesList);
        seriesSp.setAdapter(customSeriesAdapter);
    }
// todo ; change showData to Show Movie
    protected void showData() {
        movieIdTxt.setText(movie.movieId);
        movieNameTxt.setText(movie.movieName);
        movieImageUrlTxt.setText(movie.imageUrl);;
        movieDescriptionTxt.setText(movie.description);
        for (int i = 0; i<customSeriesAdapter.getCount(); i++) {
            series = customSeriesAdapter.getItem(i);
            if(movie.seriesId.equals(series.seriesId)) {
                seriesSp.setSelection(i);
            }
        }
    }
}
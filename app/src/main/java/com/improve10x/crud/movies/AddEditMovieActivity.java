package com.improve10x.crud.movies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.improve10x.crud.Constants;
import com.improve10x.crud.R;
import com.improve10x.crud.network.CrudApi;
import com.improve10x.crud.network.CrudService;
import com.improve10x.crud.series.Series;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditMovieActivity extends AppCompatActivity {
    private CustomSeriesAdapter customSeriesAdapter;
    private ArrayList<Series> seriesList = new ArrayList<>();
    private Movie movie;
    private EditText movieIdTxt;
    private EditText movieNameTxt;
    private EditText movieImageUrlTxt;
    private EditText movieDescriptionTxt;
    private Spinner seriesSp;
    private Series series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_movie);
        initValue();
        fetchSeries();
        setUpSeriesSp();

        if(getIntent().hasExtra(Constants.KEY_MOVIES)) {
            getSupportActionBar().setTitle("Edit Movie");
            movie = (Movie) getIntent().getSerializableExtra(Constants.KEY_MOVIES);
            showData();
        } else {
            getSupportActionBar().setTitle("Add Movie");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_edit_movies, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.edit) {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
            String movieId = movieIdTxt.getText().toString();
            Series series = (Series) seriesSp.getSelectedItem();
            String seriesId = series.seriesId;
            String imageUrl = movieImageUrlTxt.getText().toString();
            String movieName = movieNameTxt.getText().toString();
            String description = movieDescriptionTxt.getText().toString();
            if(movie == null) {
              addMovies(movieId, seriesId, imageUrl, movieName, description);
            } else {
                updateMovies(movie.id, movieId, seriesId, imageUrl, movieName, description);
            }
            return  true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void fetchSeries() {
        CrudApi crudApi = new CrudApi();
        CrudService crudService =  crudApi.createCrudService();
        Call<List<Series>>call = crudService.fetchSeries();
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
    private void addMovies(String movieId, String seriesId, String imageUrl, String title, String description) {
        movie = new Movie();
        movie.movieId = movieId;
        movie.seriesId = seriesId;
        movie.imageUrl = imageUrl;
        movie.name = title;
        movie.description = description;

        CrudApi crudApi = new CrudApi();
        CrudService crudService = crudApi.createCrudService();
        Call<Movie> call = crudService.createMovie(movie);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Toast.makeText(AddEditMovieActivity.this, "Successfully added the movie", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(AddEditMovieActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void updateMovies(String id, String movieId, String seriesId, String imageUrl, String title, String description) {
        movie = new Movie();
        movie.movieId = movieId;
        movie.seriesId = seriesId;
        movie.imageUrl = imageUrl;
        movie.name = title;
        movie.description = description;

        CrudApi crudApi = new CrudApi();
        CrudService crudService = crudApi.createCrudService();
        Call<Void> call = crudService.updateMovie(id, movie);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(AddEditMovieActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(AddEditMovieActivity.this, "", Toast.LENGTH_SHORT).show();


            }
        });

    }
    private void initValue() {
        seriesSp = findViewById(R.id.series_sp);
        movieIdTxt = findViewById(R.id.movie_id_txt);
        movieNameTxt = findViewById(R.id.movie_name_txt);
        movieImageUrlTxt = findViewById(R.id.movie_imageurl_txt);
        movieDescriptionTxt = findViewById(R.id.description_txt);
    }
    private void showData() {
        movieIdTxt.setText(movie.movieId);
        movieNameTxt.setText(movie.name);
        movieImageUrlTxt.setText(movie.imageUrl);;
        movieDescriptionTxt.setText(movie.description);
        for (int i = 0; i<customSeriesAdapter.getCount(); i++) {
            series = customSeriesAdapter.getItem(i);
            if(movie.seriesId.equals(series.seriesId)) {
                seriesSp.setSelection(i);
            }
        }
    }
    private void setUpSeriesSp() {

        customSeriesAdapter = new CustomSeriesAdapter(this, android.R.layout.simple_list_item_1, seriesList);
        seriesSp.setAdapter(customSeriesAdapter);
    }

}
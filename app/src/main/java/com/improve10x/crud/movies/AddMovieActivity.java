package com.improve10x.crud.movies;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.improve10x.crud.R;
import com.improve10x.crud.series.SeriesItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMovieActivity extends BaseAddEditMovieActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Movie");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.save) {
            String movieId = binding.movieIdTxt.getText().toString();
            SeriesItem series = (SeriesItem) binding.seriesSp.getSelectedItem();
            String seriesId = series.seriesId;
            String imageUrl = binding.movieImageurlTxt.getText().toString();
            String movieName = binding.movieNameTxt.getText().toString();
            String description = binding.descriptionTxt.getText().toString();
            addMovies(movieId, seriesId, imageUrl, movieName, description);
            return  true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void addMovies(String movieId, String seriesId, String imageUrl, String title, String description) {Movie movie = new Movie();
        movie.movieId = movieId;
        movie.seriesId = seriesId;
        movie.imageUrl = imageUrl;
        movie.movieName = title;
        movie.description = description;
        Call<Movie> call = crudService.createMovie(movie);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                showToast("Successfully added the movie");
                finish();
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                showToast("Failed to add the movie");
            }
        });
    }
}

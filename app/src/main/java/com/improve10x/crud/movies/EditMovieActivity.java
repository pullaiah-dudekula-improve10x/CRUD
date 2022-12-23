package com.improve10x.crud.movies;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.improve10x.crud.Constants;
import com.improve10x.crud.R;
import com.improve10x.crud.series.SeriesItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditMovieActivity extends BaseAddEditMovieActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().hasExtra(Constants.KEY_MOVIES)) {
            getSupportActionBar().setTitle("Edit Movie");
            movie = (Movie) getIntent().getSerializableExtra(Constants.KEY_MOVIES);
            showData();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.save) {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
            String movieId = binding.movieIdTxt.getText().toString();
            SeriesItem series = (SeriesItem) seriesSp.getSelectedItem();
            String seriesId = series.seriesId;
            String imageUrl = binding.movieImageurlTxt.getText().toString();
            String movieName = binding.movieNameTxt.getText().toString();
            String description = binding.descriptionTxt.getText().toString();
            updateMovie(movie.id, movieId, seriesId, imageUrl, movieName, description);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void updateMovie(String id, String movieId, String seriesId, String imageUrl, String title, String description) {
        movie = new Movie();
        movie.movieId = movieId;
        movie.seriesId = seriesId;
        movie.imageUrl = imageUrl;
        movie.movieName = title;
        movie.description = description;
        Call<Void> call = crudService.updateMovie(id, movie);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Successfully update the movie");
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed to update the movie");
            }
        });
    }
}

package com.improve10x.crud;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesApi {
    public MoviesService createMovieService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MoviesService moviesService = retrofit.create(MoviesService.class);
        return moviesService;
    }
}

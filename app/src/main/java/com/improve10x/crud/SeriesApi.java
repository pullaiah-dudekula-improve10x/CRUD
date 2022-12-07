package com.improve10x.crud;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SeriesApi {
    public SeriesService createSeriesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SeriesService seriesService = retrofit.create(SeriesService.class);
        return seriesService;
    }
}

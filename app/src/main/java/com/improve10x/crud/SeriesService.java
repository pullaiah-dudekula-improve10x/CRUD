package com.improve10x.crud;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SeriesService {
    @GET(Constants.END_POINT_SERIES)
    Call<List<Series>> fetchSeries();

    @POST(Constants.END_POINT_SERIES)
    Call<Series> createSeries (@Body Series series);
}

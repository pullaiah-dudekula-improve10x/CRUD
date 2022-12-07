package com.improve10x.crud.series;

import com.improve10x.crud.Constants;
import com.improve10x.crud.series.Series;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface SeriesService {
    @GET(Constants.END_POINT_SERIES)
    Call<List<Series>> fetchSeries();

    @POST(Constants.END_POINT_SERIES)
    Call<Series> createSeries (@Body Series series);

    @DELETE(Constants.END_POINT_SERIES + "/{id}")
    Call<Void> deleteSeries(@Path("id") String id);

    @PUT(Constants.END_POINT_SERIES + "/{id}")
    Call<Void> editSeries(@Path("id") String id, @Body Series series);
}

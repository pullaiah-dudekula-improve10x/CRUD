package com.improve10x.crud.network;

import com.improve10x.crud.Constants;
import com.improve10x.crud.Movie;
import com.improve10x.crud.messages.Message;
import com.improve10x.crud.series.Series;
import com.improve10x.crud.templates.Template;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CrudService {

    @GET(Constants.END_POINT)
    Call<List<Message>> fetchMessages();

    @POST(Constants.END_POINT)
    Call<Message> createMessage (@Body Message message);

    @DELETE(Constants.END_POINT + "/{id}")
    Call<Void> deleteMessages (@Path("id") String id);

    @PUT(Constants.END_POINT + "/{id}")
    Call<Void> editMessages (@Path("id") String id,@Body Message message);

    @GET(Constants.END_POINT_TEMPLATE)
    Call<List<Template>> fetchTemplates();

    @POST(Constants.END_POINT_TEMPLATE)
    Call<Template> createTemplates (@Body Template template);

    @DELETE(Constants.END_POINT_TEMPLATE + "/{id}")
    Call<Void> deleteTemplates(@Path("id") String id);

    @PUT(Constants.END_POINT_TEMPLATE + "/{id}")
    Call<Void> editTemplates(@Path("id") String id, @Body Template template);

    @GET(Constants.END_POINT_SERIES)
    Call<List<Series>> fetchSeries();

    @POST(Constants.END_POINT_SERIES)
    Call<Series> createSeries (@Body Series series);

    @DELETE(Constants.END_POINT_SERIES + "/{id}")
    Call<Void> deleteSeries(@Path("id") String id);

    @PUT(Constants.END_POINT_SERIES + "/{id}")
    Call<Void> editSeries(@Path("id") String id, @Body Series series);

    @GET(Constants.MOVIES_END_POINT)
    Call<List<Movie>> fetchMovies();

    @POST(Constants.MOVIES_END_POINT)
    Call<Movie> createMovie(@Body Movie movie);

    @DELETE(Constants.MOVIES_END_POINT + "/{id}")
    Call<Void> deleteMovie(@Path("id") String id);

    @PUT(Constants.MOVIES_END_POINT + "/{id}")
    Call<Void> updateMovie(@Path("id") String id, @Body Movie movie);
}

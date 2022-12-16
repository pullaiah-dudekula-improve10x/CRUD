package com.improve10x.crud.network;

import com.improve10x.crud.Constants;
import com.improve10x.crud.movies.Movie;
import com.improve10x.crud.messages.Message;
import com.improve10x.crud.series.SeriesItem;
import com.improve10x.crud.template.Template;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CrudService {

    @GET(Constants.MESSAGE_END_POINT)
    Call<List<Message>> fetchMessages();

    @POST(Constants.MESSAGE_END_POINT)
    Call<Message> createMessage (@Body Message message);

    @DELETE(Constants.MESSAGE_END_POINT + "/{id}")
    Call<Void> deleteMessages (@Path("id") String id);

    @PUT(Constants.MESSAGE_END_POINT + "/{id}")
    Call<Void> editMessages (@Path("id") String id,@Body Message message);

    @GET(Constants.TEMPLATES_END_POINT)
    Call<List<Template>> fetchTemplates();

    @POST(Constants.TEMPLATES_END_POINT)
    Call<Template> createTemplate(@Body Template template);

    @DELETE(Constants.TEMPLATES_END_POINT + "/{id}")
    Call<Void> deleteTemplate(@Path("id") String id);

    @PUT(Constants.TEMPLATES_END_POINT + "/{id}")
    Call<Void> updateTemplate(@Path("id") String id, @Body Template template);

    @GET(Constants.SERIES_END_POINT)
    Call<List<SeriesItem>> fetchSeriesItems();

    @POST(Constants.SERIES_END_POINT)
    Call<SeriesItem> createSeriesItem(@Body SeriesItem series);

    @DELETE(Constants.SERIES_END_POINT + "/{id}")
    Call<Void> deleteSeriesItem(@Path("id") String id);

    @PUT(Constants.SERIES_END_POINT + "/{id}")
    Call<Void> updateSeriesItem(@Path("id") String id, @Body SeriesItem series);

    @GET(Constants.MOVIES_END_POINT)
    Call<List<Movie>> fetchMovies();

    @POST(Constants.MOVIES_END_POINT)
    Call<Movie> createMovie(@Body Movie movie);

    @DELETE(Constants.MOVIES_END_POINT + "/{id}")
    Call<Void> deleteMovie(@Path(("id")) String id);

    @PUT(Constants.MOVIES_END_POINT + "/{id}")
    Call<Void> updateMovie(@Path("id") String id, @Body Movie movie);
}

package com.improve10x.crud.templates;

import com.improve10x.crud.Constants;
import com.improve10x.crud.templates.Template;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TemplatesService {

    @GET(Constants.END_POINT_TEMPLATE)
    Call<List<Template>> fetchTemplates();

    @POST(Constants.END_POINT_TEMPLATE)
    Call<Template> createTemplates (@Body Template template);

    @DELETE(Constants.END_POINT_TEMPLATE + "/{id}")
    Call<Void> deleteTemplates(@Path("id") String id);

    @PUT(Constants.END_POINT_TEMPLATE + "/{id}")
    Call<Void> editTemplates(@Path("id") String id, @Body Template template);
}

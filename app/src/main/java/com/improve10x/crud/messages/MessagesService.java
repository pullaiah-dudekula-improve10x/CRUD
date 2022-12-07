package com.improve10x.crud.messages;

import com.improve10x.crud.Constants;
import com.improve10x.crud.messages.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MessagesService {
    @GET(Constants.END_POINT)
    Call<List<Message>> fetchMessages();

    @POST(Constants.END_POINT)
    Call<Message> createMessage (@Body Message message);

    @DELETE(Constants.END_POINT + "/{id}")
    Call<Void> deleteMessages (@Path("id") String id);

    @PUT(Constants.END_POINT + "/{id}")
    Call<Void> editMessages (@Path("id") String id,@Body Message message);
}

package com.improve10x.crud.messages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.improve10x.crud.Constants;
import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;
import com.improve10x.crud.network.CrudApi;
import com.improve10x.crud.network.CrudService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessagesActivity extends BaseActivity {
    public ArrayList<Message> messageList = new ArrayList<>();
    private MessagesAdapter messagesAdapter;
    private RecyclerView messagesRv;
    private CrudService crudService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        log("onCreate");
        getSupportActionBar().setTitle("Messages");
        setUpMessagesRv();
        setUpApiService();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchMessages();
        log("OnResume");
    }

    private void setUpApiService() {
        CrudApi crudApi = new CrudApi();
        crudService = crudApi.createCrudService();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.messages_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add) {
            Intent intent = new Intent(this, AddEditMessagesActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void editTask(Message message) {
        Intent intent = new Intent(this, AddEditMessagesActivity.class);
        intent.putExtra(Constants.KEY_MESSAGE, message);
        startActivity(intent);

    }

    private void setUpMessagesRv() {
        messagesRv = findViewById(R.id.messages_rv);
        messagesRv.setLayoutManager(new LinearLayoutManager(this));
        messagesAdapter = new MessagesAdapter();
        messagesAdapter.setData(messageList);
        messagesAdapter.setOnItemActionClickListener(new onItemActionClickListener() {
            @Override
            public void onDelete(String id) {
                deleteMessages(id);
            }

            @Override
            public void onEdit(Message message) {
                editTask(message);

            }
        });
        messagesRv.setAdapter(messagesAdapter);
    }

    private void fetchMessages() {

        Call<List<Message>>call = crudService.fetchMessages();
        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                List<Message> messageList = response.body();
                messagesAdapter.setData(messageList);


            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {

            }
        });
    }

    private void deleteMessages(String id) {

        Call<Void> call = crudService.deleteMessages(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
               showToast("successfully delete the message");
                fetchMessages();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
               showToast("failed to delete the message");

            }
        });

    }

}
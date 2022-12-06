package com.improve10x.crud.messages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.improve10x.crud.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditMessagesActivity extends AppCompatActivity {
    public EditText nameTxt;
    public EditText phoneNumberTxt;
    public EditText messageTextTxt;
    public Message messageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_messages);
        getSupportActionBar().setTitle("Messages");
        initValues();
        if (getIntent().hasExtra("Message")) {
            getSupportActionBar().setTitle("EditMessages");
           messageList = (Message) getIntent().getSerializableExtra("Message");
           showData();
        } else {
            getSupportActionBar().setTitle("AddMessages");
        }
    }
    public void initValues() {
        nameTxt = findViewById(R.id.name_txt);
        phoneNumberTxt = findViewById(R.id.phonenumber_txt);
        messageTextTxt = findViewById(R.id.message_text_txt1);
    }
    public void showData() {
        nameTxt.setText(messageList.name);
        phoneNumberTxt.setText(messageList.phoneNumber);
        messageTextTxt.setText(messageList.messageText);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.addeditmessages_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.edit) {
            String name = this.nameTxt.getText().toString();
            String phoneNumber = this.phoneNumberTxt.getText().toString();
            String message = this.messageTextTxt.getText().toString();
            if (this.messageList == null) {
                addMessages(name, phoneNumber, message);

            } else {
                updateMessages(messageList.id, name, phoneNumber, message);

            }
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
    public void addMessages(String name, String phoneNumber, String messageText) {
        messageList = new Message();
        messageList.name = name;
        messageList.phoneNumber = phoneNumber;
        messageList.messageText = messageText;

        MessagesApi messagesApi = new MessagesApi();
        MessagesService messagesService = messagesApi.createMessageService();
        Call<Message> call = messagesService.createMessage(messageList);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Toast.makeText(AddEditMessagesActivity.this, "Successfully added the data", Toast.LENGTH_SHORT).show();
                finish();

            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Toast.makeText(AddEditMessagesActivity.this, "Failed to load the data", Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void updateMessages(String id, String name, String phoneNumber, String message) {
        messageList = new Message();
        messageList.name = name;
        messageList.phoneNumber = phoneNumber;
        messageList.messageText = message;

        MessagesApi messagesApi = new MessagesApi();
        MessagesService messagesService = messagesApi.createMessageService();
        Call<Void> call = messagesService.editMessages(id, messageList);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(AddEditMessagesActivity.this, "Successfully added the data", Toast.LENGTH_SHORT).show();
                finish();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(AddEditMessagesActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
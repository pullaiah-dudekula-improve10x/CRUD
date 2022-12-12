package com.improve10x.crud.messages;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.improve10x.crud.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMessagesActivity extends BaseAddEditMessagesActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("AddMessages");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.edit) {
            String name = this.nameTxt.getText().toString();
            String phoneNumber = this.phoneNumberTxt.getText().toString();
            String message = this.messageTextTxt.getText().toString();
                addMessages(name, phoneNumber, message);

                return true;
            }
         else {
            return super.onOptionsItemSelected(item);
        }
    }


    private void addMessages(String name, String phoneNumber, String messageText) {
        messageList = new Message();
        messageList.name = name;
        messageList.phoneNumber = phoneNumber;
        messageList.messageText = messageText;


        Call<Message> call = crudService.createMessage(messageList);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                showToast("Successfully added the message ");
                finish();

            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                showToast("Failed to add the message");

            }
        });

    }
}

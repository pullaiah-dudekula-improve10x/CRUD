package com.improve10x.crud.messages;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.improve10x.crud.Constants;
import com.improve10x.crud.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditMessageActivity extends BaseAddEditMessagesActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().hasExtra(Constants.KEY_MESSAGE)) {
            getSupportActionBar().setTitle("EditMessages");
            messageList = (Message) getIntent().getSerializableExtra(Constants.KEY_MESSAGE);
            showData();

        }
    }

    private void showData() {
        nameTxt.setText(messageList.name);
        phoneNumberTxt.setText(messageList.phoneNumber);
        messageTextTxt.setText(messageList.messageText);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.edit) {
            String name = this.nameTxt.getText().toString();
            String phoneNumber = this.phoneNumberTxt.getText().toString();
            String message = this.messageTextTxt.getText().toString();
            if (this.messageList == null) {
            } else {
                updateMessages(messageList.id, name, phoneNumber, message);

            }
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
    private void updateMessages(String id, String name, String phoneNumber, String message) {
        messageList = new Message();
        messageList.name = name;
        messageList.phoneNumber = phoneNumber;
        messageList.messageText = message;


        Call<Void> call = crudService.editMessages(id, messageList);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Successfully update the message");
                finish();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed to update the message");

            }
        });
    }


}

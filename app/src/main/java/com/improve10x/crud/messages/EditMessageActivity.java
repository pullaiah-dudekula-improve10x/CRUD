package com.improve10x.crud.messages;

import android.os.Bundle;
import android.view.MenuItem;

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
            getSupportActionBar().setTitle("Edit Messages");
            messageList = (Message) getIntent().getSerializableExtra(Constants.KEY_MESSAGE);
            showData();
        }
    }

    private void showData() {
        binding.nameTxt.setText(messageList.name);
        binding.phoneNumberTxt.setText(messageList.phoneNumber);
        binding.messageTextTxt.setText(messageList.messageText);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.save) {
            String name = this.binding.nameTxt.getText().toString();
            String phoneNumber = this.binding.phoneNumberTxt.getText().toString();
            String message = this.binding.messageTextTxt.getText().toString();
            updateMessage(messageList.id, name, phoneNumber, message);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void updateMessage(String id, String name, String phoneNumber, String message) {
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

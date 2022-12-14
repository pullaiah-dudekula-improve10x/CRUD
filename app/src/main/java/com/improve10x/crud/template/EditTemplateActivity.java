package com.improve10x.crud.template;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.improve10x.crud.Constants;
import com.improve10x.crud.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditTemplateActivity extends BaseAddEditTemplateActivity{

    private Template template;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getIntent().hasExtra(Constants.KEY_TEMPLATE)) {
            getSupportActionBar().setTitle("Edit Template");
            template = (Template) getIntent().getSerializableExtra(Constants.KEY_TEMPLATE);
            showData();
        }
    }

    private void showData() {
        messageTextTxt.setText(template.messageText);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //change edit to add
        if(item.getItemId() == R.id.save) {
            String message = messageTextTxt.getText().toString();
            editTemplates(template.id, message);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
//change method name editTemplates to editTemplate
    private void editTemplates(String id, String message) {
        template = new Template();
        template.messageText = message;
        Call<Void> call = crudService.editTemplates(id, template);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Successfully update template");
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed to upaDate template");
            }
        });
    }
}

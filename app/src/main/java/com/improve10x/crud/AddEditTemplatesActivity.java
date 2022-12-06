package com.improve10x.crud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditTemplatesActivity extends AppCompatActivity {
    public EditText messageTextTxt;
    public Template template;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_templates);
        initView();
    }

    public void initView() {
        messageTextTxt = findViewById(R.id.message_text_txt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adde_edit_templates_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.edit) {
            String message = messageTextTxt.getText().toString();
            if(template == null) {
                addMessages(message);
            } else {

            }
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
    public void addMessages(String messageText) {
        template = new Template();
        template.messageText = messageText;

        TemplatesApi templatesApi = new TemplatesApi();
        TemplatesService templatesService = templatesApi.createTemplatesService();
        Call<Template>call = templatesService.createTemplates(template);
        call.enqueue(new Callback<Template>() {
            @Override
            public void onResponse(Call<Template> call, Response<Template> response) {
                Toast.makeText(AddEditTemplatesActivity.this, "Successfully added the data", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Template> call, Throwable t) {
                Toast.makeText(AddEditTemplatesActivity.this, "Failed to load the data", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
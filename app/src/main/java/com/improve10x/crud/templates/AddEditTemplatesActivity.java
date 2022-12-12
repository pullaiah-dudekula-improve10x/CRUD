package com.improve10x.crud.templates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.improve10x.crud.Constants;
import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;
import com.improve10x.crud.network.CrudApi;
import com.improve10x.crud.network.CrudService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditTemplatesActivity extends BaseActivity {
    private EditText messageTextTxt;
    private Template template;
    private CrudService crudService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_templates);
        setUpApiService();
        initView();
        if(getIntent().hasExtra(Constants.KEY_TEMPLATE)) {
            getSupportActionBar().setTitle("EditTemplates");
           template = (Template) getIntent().getSerializableExtra(Constants.KEY_TEMPLATE);
           showData();

        } else {
            getSupportActionBar().setTitle("AddMessages");
        }
    }

    private void setUpApiService() {
        CrudApi crudApi = new CrudApi();
        crudService = crudApi.createCrudService();
    }


    private void initView() {
        messageTextTxt = findViewById(R.id.message_text_txt);
    }

    private void showData() {
        messageTextTxt.setText(template.messageText);
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
                addTemplates(message);
            } else {
                editTemplates(template.id, message);
            }
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void addTemplates(String messageText) {
        template = new Template();
        template.messageText = messageText;

        Call<Template>call = crudService.createTemplates(template);
        call.enqueue(new Callback<Template>() {
            @Override
            public void onResponse(Call<Template> call, Response<Template> response) {
                showToast("Successfully added the template");
                finish();
            }

            @Override
            public void onFailure(Call<Template> call, Throwable t) {
                showToast("Failed to add template");

            }
        });
    }

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
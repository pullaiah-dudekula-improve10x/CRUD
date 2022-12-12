package com.improve10x.crud.messages;

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

public class BaseAddEditMessagesActivity extends BaseActivity {
    protected   EditText nameTxt;
    protected   EditText phoneNumberTxt;
    protected   EditText messageTextTxt;
    protected   Message messageList;
    protected  CrudService crudService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_messages);
        getSupportActionBar().setTitle("Messages");
        initValues();
        setUpApiService();

    }

    private void setUpApiService() {
            CrudApi crudApi = new CrudApi();
            crudService = crudApi.createCrudService();
    }

    private void initValues() {
        nameTxt = findViewById(R.id.name_txt);
        phoneNumberTxt = findViewById(R.id.phonenumber_txt);
        messageTextTxt = findViewById(R.id.message_text_txt1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.addeditmessages_menu, menu);
        return true;
    }





}
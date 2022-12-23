package com.improve10x.crud.messages;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;
import com.improve10x.crud.databinding.ActivityAddEditMessagesBinding;

public class BaseAddEditMessagesActivity extends BaseActivity {

    protected ActivityAddEditMessagesBinding binding;

    protected   Message messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddEditMessagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Messages");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_edit_messages_menu, menu);
        return true;
    }
}
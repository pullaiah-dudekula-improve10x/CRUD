package com.improve10x.crud.messages;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;

public class BaseAddEditMessagesActivity extends BaseActivity {

    protected   EditText nameTxt;
    protected   EditText phoneNumberTxt;
    protected   EditText messageTextTxt;
    // todo ; change the object name as message edit in declare
    protected   Message messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_messages);
        getSupportActionBar().setTitle("Messages");
        initValues();
    }

    private void initValues() {
        nameTxt = findViewById(R.id.name_txt);
        phoneNumberTxt = findViewById(R.id.phone_number_txt);
        messageTextTxt = findViewById(R.id.message_text_txt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // todo ; change the id as add_edit_message_menu
        getMenuInflater().inflate(R.menu.add_edit_messages_menu, menu);
        return true;
    }
}
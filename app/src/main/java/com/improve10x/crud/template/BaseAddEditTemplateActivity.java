package com.improve10x.crud.template;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;
import com.improve10x.crud.network.CrudApi;
import com.improve10x.crud.network.CrudService;

public class BaseAddEditTemplateActivity extends BaseActivity {

    protected EditText messageTextTxt;
    protected CrudService crudService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_templates);
        setUpApiService();
        initView();
    }

    private void setUpApiService() {
        CrudApi crudApi = new CrudApi();
        crudService = crudApi.createCrudService();
    }
//change name initView ti initViews
    private void initView() {
        messageTextTxt = findViewById(R.id.message_text_txt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adde_edit_templates_menu, menu);
        return true;
    }
}
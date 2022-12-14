package com.improve10x.crud.series;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.improve10x.crud.Constants;
import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;
import com.improve10x.crud.network.CrudApi;
import com.improve10x.crud.network.CrudService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseAddEditSeriesActivity extends BaseActivity {

    protected EditText seriesIdTxt;
    protected EditText seriesNameTxt;
    protected EditText imageUrlTxt;
    protected CrudService crudService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_series);
        setUpApiService();
        //change name initView to initViews
        initView();
    }

    private void setUpApiService() {
        CrudApi crudApi = new CrudApi();
        crudService = crudApi.createCrudService();
    }

    private void initView() {
        seriesIdTxt = findViewById(R.id.seriesid_txt);
        seriesNameTxt = findViewById(R.id.seriesname_txt);
        imageUrlTxt = findViewById(R.id.imageurl_txt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_edit_series_menu, menu);
        return true;
    }


}
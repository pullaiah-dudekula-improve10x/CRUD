package com.improve10x.crud.series;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;
public class BaseAddEditSeriesItemsActivity extends BaseActivity {

    protected EditText seriesIdTxt;
    protected EditText seriesNameTxt;
    protected EditText imageUrlTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_series);
        initViews();
    }

    private void initViews() {
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
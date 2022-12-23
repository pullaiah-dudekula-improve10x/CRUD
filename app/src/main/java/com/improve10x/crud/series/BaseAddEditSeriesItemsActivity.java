package com.improve10x.crud.series;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;
import com.improve10x.crud.databinding.ActivityAddEditSeriesBinding;

public class BaseAddEditSeriesItemsActivity extends BaseActivity {

    protected ActivityAddEditSeriesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddEditSeriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_edit_series_menu, menu);
        return true;
    }
}
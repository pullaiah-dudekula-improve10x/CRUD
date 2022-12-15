package com.improve10x.crud.dashboard;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;

import java.util.ArrayList;

public class DashboardItemsActivity extends BaseActivity {

    private ArrayList<DashboardItem> dashboardItems;
    private RecyclerView dashboardRv;
    private DashboardAdapter dashboardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        log("onCreate");
        getSupportActionBar().setTitle("Dashboard");
        //todo : here change  setUpData u should be in lower case in classes
        setUpData();
        setupDashboardItemsRv();
    }

    private void setupDashboardItemsRv() {
        dashboardRv = findViewById(R.id.dashboard_rv);
        dashboardRv.setLayoutManager(new LinearLayoutManager(this));
        // todo  ; change  dashboardAdapter to dashboard items adapter
        dashboardAdapter = new DashboardAdapter();
        dashboardAdapter.setData(dashboardItems);
        dashboardRv.setAdapter(dashboardAdapter);
    }

    private void setUpData() {
        dashboardItems = new ArrayList<>();
        DashboardItem messages = new DashboardItem();
        messages.imageUrl = "https://static.vecteezy.com/system/resources/previews/000/338/561/original/vector-message-icon.jpg";
        messages.title = "Messages";
        dashboardItems.add(messages);

        DashboardItem templates = new DashboardItem();
        templates.imageUrl = "https://static.vecteezy.com/system/resources/previews/000/331/303/original/vector-message-icon.jpg";
        templates.title = "Templates";
        dashboardItems.add(templates);

        DashboardItem series = new DashboardItem();
        series.imageUrl = "https://i.ytimg.com/vi/faeP56TY1z4/maxresdefault.jpg";
        series.title = "Series";
        dashboardItems.add(series);

        DashboardItem movies = new DashboardItem();
        movies.imageUrl = "https://tse4.mm.bing.net/th?id=OIP.Fswmb62BFVQukj5U-HFXrAHaEK&pid=Api&P=0";
        movies.title = "Movies";
        dashboardItems.add(movies);
    }
}
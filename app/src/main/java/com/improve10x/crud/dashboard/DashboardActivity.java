package com.improve10x.crud.dashboard;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;

import java.util.ArrayList;
// todo; change class name DashboardActivity to DashboardItemsActivity
public class DashboardActivity extends BaseActivity {

    private ArrayList<Dashboard> dashboardItems;
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
        setupDashboardRv();
    }
//todo: change setupDashboardRv to setupDashboardItemsRv
    private void setupDashboardRv() {
        dashboardRv = findViewById(R.id.dashboard_rv);
        dashboardRv.setLayoutManager(new LinearLayoutManager(this));
        dashboardAdapter = new DashboardAdapter();
        dashboardAdapter.setData(dashboardItems);
        dashboardRv.setAdapter(dashboardAdapter);
    }

    private void setUpData() {
        dashboardItems = new ArrayList<>();
        Dashboard messages = new Dashboard();
        messages.imageUrl = "https://static.vecteezy.com/system/resources/previews/000/338/561/original/vector-message-icon.jpg";
        messages.title = "Messages";
        dashboardItems.add(messages);

        Dashboard templates = new Dashboard();
        templates.imageUrl = "https://static.vecteezy.com/system/resources/previews/000/331/303/original/vector-message-icon.jpg";
        templates.title = "Templates";
        dashboardItems.add(templates);

        Dashboard series = new Dashboard();
        series.imageUrl = "https://i.ytimg.com/vi/faeP56TY1z4/maxresdefault.jpg";
        series.title = "Series";
        dashboardItems.add(series);

        Dashboard movies = new Dashboard();
        movies.imageUrl = "https://tse4.mm.bing.net/th?id=OIP.Fswmb62BFVQukj5U-HFXrAHaEK&pid=Api&P=0";
        movies.title = "Movies";
        dashboardItems.add(movies);
    }
}
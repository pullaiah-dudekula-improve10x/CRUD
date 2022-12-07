package com.improve10x.crud.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.improve10x.crud.R;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {
    public ArrayList<Dashboard> dashboards;
    public RecyclerView dashboardRv;
    public DashboardAdapter dashboardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setTitle("Dashboard");
        setUpData();
        setUpDashboardRv();
    }

    private void setUpDashboardRv() {
        dashboardRv = findViewById(R.id.dashboard_rv);
        dashboardRv.setLayoutManager(new LinearLayoutManager(this));
        dashboardAdapter = new DashboardAdapter();
        dashboardAdapter.setData(dashboards);
        dashboardRv.setAdapter(dashboardAdapter);
    }

    private void setUpData() {
        dashboards = new ArrayList<>();
        Dashboard messages = new Dashboard();
        messages.imageUrl = "https://www.mediashower.com/img/2233/first%20text.jpg";
        messages.title = "Messages";
        dashboards.add(messages);

        Dashboard templates = new Dashboard();
        templates.imageUrl = "texttasy.com/img/message.svg";
        templates.title = "Templates";
        dashboards.add(templates);

        Dashboard series = new Dashboard();
        series.imageUrl = "http://images5.fanpop.com/image/photos/29000000/harry-potter-harry-potter-29097111-1024-768.jpg";
        series.title = "Series";
        dashboards.add(series);

        Dashboard movies = new Dashboard();
        movies.imageUrl = "https://tse4.mm.bing.net/th?id=OIP.Fswmb62BFVQukj5U-HFXrAHaEK&pid=Api&P=0";
        movies.title = "Movies";
        dashboards.add(movies);

    }
}
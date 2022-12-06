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
        messages.imageUrl = "https://media.istockphoto.com/id/1161794768/vector/mail-notification-on-white-bubble.jpg?s=612x612&w=0&k=20&c=jajRBgyArIz9jQ_dbekxvkMGJY1_8yoZgzhNnKAQ9Wc=";
        messages.title = "Messages";
        dashboards.add(messages);

        Dashboard templates = new Dashboard();
        templates.imageUrl = "https://play-lh.googleusercontent.com/9AZOTXU_CpreTFAXUPAmJNkm8VGCb1C90fjJ9pHGcVmpGMDSTq3cUbaQJdBT9Tdp9A";
        templates.title = "Templates";
        dashboards.add(templates);

        Dashboard series = new Dashboard();
        series.imageUrl = "https://play-lh.googleusercontent.com/vEYNbuYGPL1RtALdzKXuB-u9heze526psSAdI-I2hgkV2Zoo2FADYxb5CLVdD734ZyU";
        series.title = "Series";
        dashboards.add(series);

        Dashboard movies = new Dashboard();
        movies.imageUrl = "https://thumbs.dreamstime.com/b/android-messages-app-logo-meet-google-s-official-texting-chat-web-kyiv-ukraine-june-186059516.jpg";
        movies.title = "Movies";
        dashboards.add(movies);

    }
}
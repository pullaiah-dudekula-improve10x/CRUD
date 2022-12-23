package com.improve10x.crud.dashboard;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;
import com.improve10x.crud.databinding.ActivityDashboardBinding;

import java.util.ArrayList;

public class DashboardItemsActivity extends BaseActivity {

    private ActivityDashboardBinding binding;
    private ArrayList<DashboardItem> dashboardItems;
    private DashboardItemsAdapter dashboardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        log("onCreate");
        getSupportActionBar().setTitle("Dashboard");
        setupData();
        setupDashboardItemsRv();
    }

    private void setupDashboardItemsRv() {
        binding.dashboardItemRv.setLayoutManager(new LinearLayoutManager(this));
        dashboardAdapter = new DashboardItemsAdapter();
        dashboardAdapter.setData(dashboardItems);
        binding.dashboardItemRv.setAdapter(dashboardAdapter);
    }

    private void setupData() {
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
package com.improve10x.crud.templates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.improve10x.crud.Constants;
import com.improve10x.crud.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TemplatesActivity extends AppCompatActivity {

    private ArrayList<Template> templates = new ArrayList<>();
    private RecyclerView templatesRv;
    private TemplatesAdapter templatesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates);
        getSupportActionBar().setTitle("Templates");
        setUpTemplatesRv();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchTemplates();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.templates_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add) {
            Intent intent = new Intent(this, AddEditTemplatesActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void ediTask(Template template) {
        Intent intent = new Intent(this, AddEditTemplatesActivity.class);
        intent.putExtra(Constants.KEY_TEMPLATE, template);
        startActivity(intent);
    }

    private void setUpTemplatesRv() {
        templatesRv = findViewById(R.id.templates_rv);
        templatesRv.setLayoutManager(new LinearLayoutManager(this));
        templatesAdapter = new TemplatesAdapter();
        templatesAdapter.setData(templates);
        templatesAdapter.setOnItemActionClickListener(new OnItemActionClickListener() {
            @Override
            public void onDelete(String id) {
                deleteMessages(id);
            }

            @Override
            public void onEdit(Template template) {
                ediTask(template);

            }
        });
        templatesRv.setAdapter(templatesAdapter);
    }

    private void fetchTemplates() {
        TemplatesApi templatesApi = new TemplatesApi();
        TemplatesService templatesService = templatesApi.createTemplatesService();
        Call<List<Template>> call = templatesService.fetchTemplates();
        call.enqueue(new Callback<List<Template>>() {
            @Override
            public void onResponse(Call<List<Template>> call, Response<List<Template>> response) {
                List<Template>templates = response.body();
                templatesAdapter.setData(templates);
            }

            @Override
            public void onFailure(Call<List<Template>> call, Throwable t) {

            }
        });

    }

    private void deleteMessages(String id) {
        TemplatesApi templatesApi = new TemplatesApi();
        TemplatesService templatesService = templatesApi.createTemplatesService();
        Call<Void>call = templatesService.deleteTemplates(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(TemplatesActivity.this, "Succesfully delete the template", Toast.LENGTH_SHORT).show();
                fetchTemplates();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(TemplatesActivity.this, "Failed delete the template", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
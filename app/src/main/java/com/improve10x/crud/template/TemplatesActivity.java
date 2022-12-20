package com.improve10x.crud.template;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.improve10x.crud.Constants;
import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TemplatesActivity extends BaseActivity {

    private ArrayList<Template> templates = new ArrayList<>();
    private RecyclerView templatesRv;
    private TemplatesAdapter templatesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates);
        log("onCreate");
        getSupportActionBar().setTitle("Templates");
        setUpTemplatesRv();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchTemplates();
        log("onResume");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.templates_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add) {
            Intent intent = new Intent(this, AddTemplateActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void ediTemplate(Template template) {
        Intent intent = new Intent(this, EditTemplateActivity.class);
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
                deleteTemplates(id);
            }

            @Override
            public void onEdit(Template template) {
                ediTemplate(template);
            }
        });
        templatesRv.setAdapter(templatesAdapter);
    }

    private void fetchTemplates() {
        Call<List<Template>> call = crudService.fetchTemplates();
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
// todo ; change method name delete templates to delete template
    private void deleteTemplates(String id) {
        Call<Void>call = crudService.deleteTemplate(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Successfully deleted the template ");
                fetchTemplates();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed to delete template ");
            }
        });
    }
}
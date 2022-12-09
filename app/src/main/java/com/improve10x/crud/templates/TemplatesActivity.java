package com.improve10x.crud.templates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.improve10x.crud.Constants;
import com.improve10x.crud.R;
import com.improve10x.crud.network.CrudApi;
import com.improve10x.crud.network.CrudService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TemplatesActivity extends AppCompatActivity {

    private ArrayList<Template> templates = new ArrayList<>();
    private RecyclerView templatesRv;
    private TemplatesAdapter templatesAdapter;
    private CrudService crudService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates);
        Log.i("TemplatesActivity", "OnCreateCalled");
        getSupportActionBar().setTitle("Templates");
        setUpTemplatesRv();
        setUpApiService();
    }

    private void setUpApiService() {
        CrudApi crudApi = new CrudApi();
        crudService = crudApi.createCrudService();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TemplatesActivity", "OnResumeCalled");
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
                deleteTemplates(id);
            }

            @Override
            public void onEdit(Template template) {
                ediTask(template);

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

    private void deleteTemplates(String id) {

        Call<Void>call = crudService.deleteTemplates(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Successfully delete the template ");
                fetchTemplates();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed to delete templates ");

            }
        });

    }
}
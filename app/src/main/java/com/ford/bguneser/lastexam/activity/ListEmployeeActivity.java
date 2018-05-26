package com.ford.bguneser.lastexam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;


import com.ford.bguneser.lastexam.R;
import com.ford.bguneser.lastexam.adapters.EmployeeListAdapter;
import com.ford.bguneser.lastexam.model.DbContext;
import com.ford.bguneser.lastexam.model.entity.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListEmployeeActivity extends AppCompatActivity {



    private ListView listView;
    EmployeeListAdapter employeeListAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.employeelist);
        initializeComponents();
        registerViewEvents();

    }

    private void initializeComponents() {

        listView = (ListView) findViewById(R.id.listView);


    }

    private void registerViewEvents() {



        DbContext.getInstance().employeefindAll(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                final List<Employee> employees = response.body();
               employeeListAdapter = new EmployeeListAdapter(ListEmployeeActivity.this, employees);
                listView.setAdapter(employeeListAdapter);
            }



            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {

            }
        });
    }


}

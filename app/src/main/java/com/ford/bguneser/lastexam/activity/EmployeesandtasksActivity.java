package com.ford.bguneser.lastexam.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.ford.bguneser.lastexam.R;

/**
 * Created by bguneser on 21.04.2018.
 */

public class EmployeesandtasksActivity extends Activity {

    private ImageButton btnEmployees;
    private ImageButton btnTasks ;
    private Button btn_CalisanEkle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.employeesandtasks );
        initializeComponents();
        registerViewEvents();

    }


    private void initializeComponents() {

        btnEmployees=findViewById( R.id.btn_Listemployees );
        btnTasks=findViewById( R.id.btn_Listtasks );
        btn_CalisanEkle=(Button)findViewById( R.id.btn_calisanEkle );
    }


    private void registerViewEvents() {

        btn_CalisanEkle.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmployeesandtasksActivity.this,PostEmployeeActivity.class));
            }
        } );

        btnTasks.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmployeesandtasksActivity.this,listTasksActivity.class));
            }
        } );

        btnEmployees.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity( new Intent( EmployeesandtasksActivity.this,ListEmployeeActivity.class ) );
            }
        } );
    }
}

package com.ford.bguneser.lastexam.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.ford.bguneser.lastexam.R;
import com.ford.bguneser.lastexam.model.DbContext;
import com.ford.bguneser.lastexam.model.entity.Employee;
import com.ford.bguneser.lastexam.model.entity.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostEmployeeActivity extends AppCompatActivity {

   private int i =0;

    List<Task> task = new ArrayList <Task>(  ) ;
    Button selectDate;
    Button selectExpDate;
    TextView date ;
    TextView expireDate;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayofMonth;
    Calendar calendar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.add_employee_layout );

        selectDate=findViewById( R.id.btnDate );
        selectExpDate = findViewById( R.id. btnExpDate);
        date = findViewById( R.id.tvSelectDate );
        expireDate = findViewById( R.id.tvExpSelectDate );

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                dayofMonth=calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(PostEmployeeActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                                date.setText( day+"/"+month+"/"+year );
                            }
                        }, year, month, dayofMonth);

                datePickerDialog.show();
            }
        }) ;




        selectExpDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                dayofMonth=calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(PostEmployeeActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                                expireDate.setText( day+"/"+month+"/"+year );
                            }
                        }, year, month, dayofMonth);

                datePickerDialog.show();
            }
        }) ;


    } ;

    public void postEmployeeToWebService(View view) throws ParseException {

        EditText taskDescription = (EditText)findViewById( R.id.et_employeeTask );
        Employee employee=new Employee();

       SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );

       Date dt  = sdf.parse(date.getText().toString());

       Date expDt = sdf.parse( expireDate.getText().toString() );

        task.add( new Task() ) ;

        task.get( i ).setTaskname(  taskDescription.getText().toString() );

        task.get( i ).setBeginingdate( dt );
        task.get( i ).setExpiredate( expDt );



        EditText isimEditText = (EditText)findViewById( R.id.et_employeeName );
        EditText soyisimEditText=(EditText)findViewById( R.id.et_employeeSurname );


        employee.setFirstname( isimEditText.getText().toString());
        employee.setLastname( soyisimEditText.getText().toString() );
        employee.setTasks( task );


        DbContext.getInstance().save( employee,task.get( i ), new Callback <Employee>() {
            @Override
            public void onResponse(Call <Employee> call, Response <Employee> response) {

            }

            @Override
            public void onFailure(Call <Employee> call, Throwable t) {

            }
        }, new Callback <Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {

            }

            @Override
            public void onFailure(Call <Task> call, Throwable t) {

            }
        } );






    }
}

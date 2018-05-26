package com.ford.bguneser.lastexam.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import com.ford.bguneser.lastexam.R;

import java.util.Date;

public class AddTaskActivity extends Activity {

    private Button addTaskButton;
    private EditText task_name;
    private CalendarView calendarView;
    private String expireDate;
    String taskName="";
    private  static  final String TAG="AddTaskActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);
        initializeComponents();
        registerViewEvent();

    }
    private void initializeComponents(){
        addTaskButton=findViewById(R.id.btn_submit_task);
        task_name=findViewById(R.id.task_name);
        calendarView = findViewById(R.id.expire_date);
    }

    private  void registerViewEvent(){

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                int d = dayOfMonth;
                int m = month;
                int y= year;
                expireDate =String.valueOf(d) + "/" + String.valueOf(m+1) + "/" + String.valueOf(y);
            }
        });

        addTaskButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                    taskName = task_name.getText().toString();
                    //Alınan task adı ve expire date'in veritabanına kayıt edilecegi yer
                    String taskExDate = DateFormat.format("MM/dd/yyyy", new Date(expireDate)).toString();
                    Log.i(TAG, "name: " + taskName);
                    Log.i(TAG, "date: " + taskExDate);
            }
        });
    }
}

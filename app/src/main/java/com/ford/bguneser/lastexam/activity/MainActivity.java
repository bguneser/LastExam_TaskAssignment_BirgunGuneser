package com.ford.bguneser.lastexam.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ford.bguneser.lastexam.model.DbContext;
import com.ford.bguneser.lastexam.model.entity.Employee;
import com.ford.bguneser.lastexam.model.entity.User;


import com.ford.bguneser.lastexam.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity" ;
    private EditText password ;
    private EditText username ;
    private Button btnLogin ;
    private Button btnCrtUser;
    private List<User> userList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        initilizeComponents();
        registerViewEvent();
    }


    private void initilizeComponents() {

        password = findViewById( R.id.txt_password );
        username = findViewById( R.id.txt_username );
        btnLogin = findViewById( R.id.btn_login );

        btnCrtUser=findViewById( R.id.btn_crtuser);
    }
    private void registerViewEvent() {




        btnLogin.setOnClickListener( new View.OnClickListener() {


            @Override
            public void onClick(View v) {

            }
        } );


        btnLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DbContext.getInstance().userfindById(1, new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, final Response<User> response) {

                        btnLogin.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if ((username.getText().toString().equals(response.body().getUsername().toString()))&&(password.getText().toString().equals(response.body().getPassword().toString()))){
                                    startActivity( new Intent( MainActivity.this,EmployeesandtasksActivity.class ) );
                                }
                                else{

                                }
                            }
                        });
                        //txtlist.setText((CharSequence) response.body().getUsername()+response.body().getPassword();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                        Log.e(TAG, "onFailure: Error", t);
                    }
                });
            }

        } );


        btnCrtUser.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CreateUserActivity.class));
            }
        } );



    }
}

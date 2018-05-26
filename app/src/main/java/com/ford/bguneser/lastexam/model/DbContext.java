package com.ford.bguneser.lastexam.model;


import com.ford.bguneser.lastexam.model.entity.Employee;
import com.ford.bguneser.lastexam.model.entity.Task;
import com.ford.bguneser.lastexam.model.entity.User;
import com.ford.bguneser.lastexam.model.service.RestEmployeeService;
import com.ford.bguneser.lastexam.model.service.RestTaskService;
import com.ford.bguneser.lastexam.model.service.RestUserService;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DbContext {

    private static final DbContext DB_CONTEXT;

    private static final String BASE_URL = "http://192.168.2.7:8080/" ;

            // "http://192.168.2.7:8080/";

    static {
        DB_CONTEXT = new DbContext();
    }

    private final RestEmployeeService restEmployeeService;
    private  final RestTaskService restTaskService;
    private final RestUserService restUserService;

    private DbContext() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .connectTimeout(1, TimeUnit.MINUTES)
//                .readTimeout(30, TimeUnit.SECONDS)
//                .writeTimeout(15, TimeUnit.SECONDS)
//                .build();
//
//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl("http://10.0.2.2:3000/")
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create());

        this.restEmployeeService = retrofit.create(RestEmployeeService.class);
        this.restTaskService = retrofit.create(RestTaskService.class);
        this.restUserService = retrofit.create(RestUserService.class);


    }

    public static DbContext getInstance() {
        return DB_CONTEXT;
    }

    public void save(Employee employee, Task task, Callback<Employee> call, Callback<Task> calltask) {
        restEmployeeService.save(employee).enqueue(call);
        restTaskService.save(task).enqueue(calltask);
    }


    public void employeedelete(long id, Callback<Void> call) {
        restEmployeeService.delete(id).enqueue(call);
    }

    public void employeefindAll(Callback<List<Employee>> callback)  {
        restEmployeeService.findAll().enqueue(callback);
    }

    public void taskfindAll(Callback<List<Task>> callback)  {
        restTaskService.findAll().enqueue(callback);
    }

    public void userfindById(long id, Callback<User> calluser){
        restUserService.findById(id).enqueue(calluser);
    }

    public void deleteTask(long id,Callback<Void> call){

        restTaskService.delete( id ).enqueue( call );
    }




}

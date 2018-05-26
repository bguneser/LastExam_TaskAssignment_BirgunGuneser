package com.ford.bguneser.lastexam.model.service;

import com.ford.bguneser.lastexam.model.entity.Employee;
import com.ford.bguneser.lastexam.model.entity.Task;


import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RestTaskService {

    @POST("tasks")
    public abstract Call<Task> save(@Body Task task);

    @PUT("tasks/{id}")
    public abstract Call<Task> update(@Path("id") long id, @Body Task task);

    @DELETE("tasks/{id}")
    public abstract Call<Void> delete(@Path("id") long id);

    @GET("tasks")
    public abstract Call<List<Task>> findAll();

    @GET("tasks/{id}")
    public abstract Call<Task> findById(@Path("id") long id);


}

package com.ford.bguneser.lastexam.model.service;



import com.ford.bguneser.lastexam.model.entity.Employee;
import com.ford.bguneser.lastexam.model.entity.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RestEmployeeService {

    @POST("employees")
    public abstract Call<Employee> save(@Body Employee employee);
    public abstract Call<Task> save(@Body Task task);

    @PUT("employees/{id}")
    public abstract Call<Employee> update(@Path("id") long id, @Body Employee employee);

    @DELETE("employees/{id}")
    public abstract Call<Void> delete(@Path("id") long id);

    @GET("employees")
    public abstract Call<List<Employee>> findAll();

    @GET("employees/{id}")
    public abstract Call<Employee> findById(@Path("id") long id);

}


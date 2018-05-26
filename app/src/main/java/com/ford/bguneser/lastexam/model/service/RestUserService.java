package com.ford.bguneser.lastexam.model.service;



import com.ford.bguneser.lastexam.model.entity.User;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestUserService {

    @POST("users/{id}")
    public abstract Call<User> findById(@Path("id") long id);


}

package ru.list.victor_90.study.myapplication;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IBaasApi {

    @POST("v1/users/login")
    Call<Users> login(@Body LoginRequest loginRequest);
}

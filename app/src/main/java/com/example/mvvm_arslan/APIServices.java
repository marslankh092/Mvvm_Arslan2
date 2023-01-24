package com.example.mvvm_arslan;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
//    //http://192.168.100.199/api/json_user_fetch.php
public interface APIServices
{
    //172.20.10.7
    @GET("json_user_fetch.php")
    Call<List<ModelEmployees>> getMovieList();
}
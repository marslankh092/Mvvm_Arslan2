package com.example.mvvm_arslan;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel
{
    private MutableLiveData<List<ModelEmployees>> movielist;

    public MovieListViewModel(){        movielist=new MutableLiveData<>();    }


    public MutableLiveData<List<ModelEmployees>> getMovielistObserver()
    {
        return movielist;
    }

    public void makeApiCall()
    {
        APIServices apiServices= RetroInstance.getRetroClient().create(APIServices.class);
        Call<List<ModelEmployees>> call=apiServices.getMovieList();
        call.enqueue(new Callback<List<ModelEmployees>>() {
            @Override
            public void onResponse(Call<List<ModelEmployees>> call, Response<List<ModelEmployees>> response) {
                movielist.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ModelEmployees>> call, Throwable t) {
                movielist.postValue(null);
                Log.e("Error :",t.getMessage().toString());
            }
        });


    }
}
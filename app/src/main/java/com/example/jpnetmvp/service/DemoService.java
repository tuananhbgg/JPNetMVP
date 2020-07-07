package com.example.jpnetmvp.service;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DemoService {
    public Retrofit getInstant(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://210.245.87.82:8585/jappserver/s/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}

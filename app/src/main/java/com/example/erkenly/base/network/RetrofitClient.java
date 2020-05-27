package com.example.erkenly.base.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofitInstance;
    private static String baseUrl = "http://erkenly.BOBwebhostapp.com/api/";
    public static Retrofit getRetrofitInstance(){
        if (retrofitInstance==null){
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitInstance;
    }
}

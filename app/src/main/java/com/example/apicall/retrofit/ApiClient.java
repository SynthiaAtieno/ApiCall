package com.example.apicall.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static  String BaseUrl = "https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit = null;

    public static ApiInterface getApiClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return  retrofit.create(ApiInterface.class);
    }
}

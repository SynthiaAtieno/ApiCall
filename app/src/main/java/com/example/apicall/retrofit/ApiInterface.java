package com.example.apicall.retrofit;

import com.example.apicall.models.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Call<List<PostsModel>> getPosts();
}

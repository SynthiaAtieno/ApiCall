package com.example.apicall.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.apicall.R;
import com.example.apicall.adapter.PostsAdapter;
import com.example.apicall.models.PostsModel;
import com.example.apicall.retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<PostsModel> postsModelList = new ArrayList<>();
    PostsAdapter postsAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postsAdapter = new PostsAdapter(postsModelList);
        recyclerView.setAdapter(postsAdapter);
        progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Fetching Data...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        ApiClient.getApiClient().getPosts().enqueue(new Callback<List<PostsModel>>() {
            @Override
            public void onResponse(Call<List<PostsModel>> call, Response<List<PostsModel>> response) {
                if (response.isSuccessful() && response.body() != null){
                    postsModelList.addAll(response.body());
                    postsAdapter.notifyDataSetChanged();
                    progressDialog.dismiss();
                }
                else {
                    Toast.makeText(MainActivity.this, "Response not successful", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<PostsModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error Occurred"+t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}
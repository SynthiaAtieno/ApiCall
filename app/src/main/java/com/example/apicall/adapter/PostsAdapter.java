package com.example.apicall.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apicall.R;
import com.example.apicall.models.PostsModel;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {
    List<PostsModel> postsModelsList;

    public PostsAdapter(List<PostsModel> postsModels) {
        this.postsModelsList = postsModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new PostsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PostsModel post = postsModelsList.get(position);

        holder.idtxt.setText(post.getId().toString());
        holder.useridtxt.setText(post.getUserId().toString());
        holder.bodytxt.setText(post.getBody());
        holder.titletxt.setText(post.getTitle());
    }

    @Override
    public int getItemCount() {
        return postsModelsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView idtxt, useridtxt, titletxt, bodytxt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idtxt = itemView.findViewById(R.id.id);
            useridtxt = itemView.findViewById(R.id.user_id);
            titletxt = itemView.findViewById(R.id.title);
            bodytxt = itemView.findViewById(R.id.body);
        }
    }
}

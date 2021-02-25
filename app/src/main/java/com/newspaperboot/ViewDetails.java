package com.newspaperboot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.newspaperboot.model.PostModel;
import com.newspaperboot.service.PostService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewDetails extends AppCompatActivity {
    PostService postService;
Intent i;
ImageView imageView;
TextView title;
TextView desc;
Context ctx;
    Uri imageuri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        ctx=this;
        postService = RetrofitConf.createService(PostService.class);
        title = findViewById(R.id.title);
        desc = findViewById(R.id.desc);
        imageView = findViewById(R.id.fimg);
         i = getIntent();
        long id = i.getLongExtra("id", 0);
        Call<PostModel> post = postService.getById(id);
        post.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                PostModel post = response.body();
                title.setText(post.getPtitle());
                desc.setText(post.getPdesc());
                imageuri = Uri.parse(post.getFimage());
                Picasso.get().load(imageuri).into(imageView);
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {

            }
        });



    }
}
package com.newspaperboot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.newspaperboot.adapter.PostAdapter;
import com.newspaperboot.model.PostModel;
import com.newspaperboot.service.PostService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatepostList extends AppCompatActivity {
    PostService postService;
    TextView title;
    Intent i;
    Context ctx;
    GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catepost_list);
        ctx=this;
        postService = RetrofitConf.createService(PostService.class);
        gv = findViewById(R.id.gv);
        i = getIntent();
        String cname = i.getStringExtra("cname");
        Call<List<PostModel>> list = postService.getByCat(cname);
        System.out.println(list+"================");
        list.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                List list = response.body();
                if (list != null && list.size() > 0) {
                    showPostlist(list);
                } else {
                    System.out.println("not found====");
                }
            }
            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
            }
        });
    }
    private void showPostlist(List<PostModel> list) {

        PostAdapter adapter = new PostAdapter(this,list);
        gv.setAdapter(adapter);
    }
}
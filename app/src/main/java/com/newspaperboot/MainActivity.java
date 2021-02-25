package com.newspaperboot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import com.newspaperboot.adapter.PostAdapter;
import com.newspaperboot.model.PostModel;
import com.newspaperboot.service.PostService;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    PostService postService;
//    ListView postGv;
    GridView postGv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postService = RetrofitConf.createService(PostService.class);
        postGv = findViewById(R.id.gv);
        Call<List<PostModel>> list = postService.getAll();
        list.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                List list = response.body();
                if (list !=null && list.size()>0){
                    showPostlist(list);
                }else {
                    System.out.println("not found====");
                }
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {t.printStackTrace();
            }
        });
    }

    private void showPostlist(List<PostModel> list) {
        PostAdapter adapter = new PostAdapter(this,list);
        postGv.setAdapter(adapter);

    }

}
package com.newspaperboot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.newspaperboot.adapter.PostAdapter;
import com.newspaperboot.model.PostModel;
import com.newspaperboot.service.PostService;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    PostService postService;
//    ListView postGv;
    GridView postGv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl = findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.open,R.string.close);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "My Account",Toast.LENGTH_SHORT).show();break;
                    case R.id.settings:
                        Toast.makeText(MainActivity.this, "Settings",Toast.LENGTH_SHORT).show();break;
                    case R.id.mycart:
                        Toast.makeText(MainActivity.this, "My Cart", Toast.LENGTH_SHORT).show();break;
                    default:
                        return true;
                }

                return true;

            }
        });
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

}

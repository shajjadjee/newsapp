package com.newspaperboot.fragment;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.newspaperboot.R;
import com.newspaperboot.RetrofitConf;
import com.newspaperboot.adapter.PostAdapter;
import com.newspaperboot.adapter.PostReAdapter;
import com.newspaperboot.model.PostModel;
import com.newspaperboot.service.PostService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    PostService postService;
//    RecyclerView gv;
    GridView gv;
    PostReAdapter postReAdapter;
    List<PostModel> list;
    Uri imageuri;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        super.onCreate(savedInstanceState);
        postService = RetrofitConf.createService(PostService.class);
        gv = v.findViewById(R.id.gv);
        Call<List<PostModel>> list = postService.getAll();
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
                t.printStackTrace();
            }
        });
        return v;
    }
    private void showPostlist(List<PostModel> list) {
//        postReAdapter = new PostReAdapter(getActivity(),list,imageuri);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3,RecyclerView.VERTICAL,false);
//        gv.setLayoutManager(gridLayoutManager);
//        gv.setAdapter(postReAdapter);
        PostAdapter adapter = new PostAdapter(getActivity(),list);
        gv.setAdapter(adapter);
    }

}
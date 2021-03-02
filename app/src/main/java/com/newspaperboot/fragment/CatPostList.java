package com.newspaperboot.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.newspaperboot.R;
import com.newspaperboot.RetrofitConf;
import com.newspaperboot.adapter.PostAdapter;
import com.newspaperboot.model.PostModel;
import com.newspaperboot.service.PostService;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CatPostList extends Fragment {
    PostService postService;
    GridView gv;
    String title;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cat_post_list, container, false);
        super.onCreate(savedInstanceState);
        postService = RetrofitConf.createService(PostService.class);
        gv = v.findViewById(R.id.gv);
//        Bundle b = new Bundle();
        String s = getArguments().getString("title","");
        System.out.println(s+"================");

        Call<List<PostModel>> list = postService.getByCat(s);
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
        return v;
    }
    private void showPostlist(List<PostModel> list) {

        PostAdapter adapter = new PostAdapter(getActivity(),list);
        gv.setAdapter(adapter);
    }
    public String getTitle()
    {
        if( title == null )
        {
            title = getArguments().getString("title");
        }
        return title;
    }
}
package com.newspaperboot.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.newspaperboot.R;
import com.newspaperboot.RetrofitConf;
import com.newspaperboot.ViewDetails;
import com.newspaperboot.fragment.HomeFragment;
import com.newspaperboot.model.CatModel;
import com.newspaperboot.model.PostModel;
import com.newspaperboot.service.CatService;

import java.util.List;

public class CatAdapter extends ArrayAdapter<CatModel> {
    Activity context;
    List<CatModel> list;
    List<PostModel> lists;
    CatService catService;
    public CatAdapter(Activity context, List<CatModel> list) {
        super(context, R.layout.postgv, list);
        catService = RetrofitConf.createService(CatService.class);
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        CatModel cat = list.get(position);
        PostModel post = lists.get(position);
        View rowview =inflater.inflate(R.layout.postgv,null,true);
        TextView title = rowview.findViewById(R.id.title);
        title.setText(cat.getCname());
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CatModel cat = list.get(position);
                PostModel post = lists.get(position);
                Intent i = new Intent(context, HomeFragment.class);
                i.putExtra("cname",post.getCname());
                context.startActivity(i);
            }
        });

        return rowview;
    }
}

package com.newspaperboot.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.newspaperboot.CatepostList;
import com.newspaperboot.ViewDetails;
import com.newspaperboot.fragment.CatPostList;
import com.newspaperboot.R;
import com.newspaperboot.RetrofitConf;
import com.newspaperboot.model.CatModel;
import com.newspaperboot.model.PostModel;
import com.newspaperboot.service.CatService;

import java.util.List;

public class CatAdapter extends ArrayAdapter<CatModel> {
    Activity context;
    List<CatModel> list;
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
        View rowview =inflater.inflate(R.layout.postgv,null,true);
        TextView title = rowview.findViewById(R.id.title);
        title.setText(cat.getCname());
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragment transaction er jonne aage fragment class er obj tarpor transaction kaaj korbe noile error asbe.
                CatPostList cp = new CatPostList();
                FragmentTransaction fragmentManager =((FragmentActivity)context).getSupportFragmentManager()
                        .beginTransaction();
                CatModel cat = list.get(position);
                Bundle b = new Bundle();
                b.putString("title",cat.getCname().toString());
                cp.setArguments(b);
                fragmentManager.replace(R.id.flContent, cp);
                fragmentManager.commit();

//                CatModel post = list.get(position);
//                Intent i = new Intent(context, CatepostList.class);
//                i.putExtra("cname",post.getCname());
//                context.startActivity(i);
            }
        });

        return rowview;
    }
}

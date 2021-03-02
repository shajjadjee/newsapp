package com.newspaperboot.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.newspaperboot.R;
import com.newspaperboot.RetrofitConf;
import com.newspaperboot.ViewDetails;
import com.newspaperboot.fragment.HomeFragment;
import com.newspaperboot.model.PostModel;
import com.newspaperboot.service.PostService;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostAdapter extends ArrayAdapter<PostModel> {
    Activity context;
    List<PostModel> list;
    PostService postService;
    Uri imageuri;
    public PostAdapter(Activity context, List<PostModel> list) {
//        super(context, R.layout.postgv, list);
        super(context, R.layout.item_home_recent_post_list, list);
        postService = RetrofitConf.createService(PostService.class);
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        PostModel post = list.get(position);
        View rowview =inflater.inflate(R.layout.item_home_recent_post_list,null,true);
//        View rowview =inflater.inflate(R.layout.postgv,null,true);
        imageuri = Uri.parse(post.getFimage());
        TextView title = rowview.findViewById(R.id.title);
        TextView date_text = rowview.findViewById(R.id.date_text);
        ImageView photo = rowview.findViewById(R.id.imagev);
        title.setText(post.getPtitle().substring(0,30));
        date_text.setText(post.getPdate());
        Picasso.get().load(imageuri).into(photo);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostModel post = list.get(position);
                Intent i = new Intent(context, ViewDetails.class);
                i.putExtra("id",post.getId());
                context.startActivity(i);
            }
        });

        return rowview;
    }
}

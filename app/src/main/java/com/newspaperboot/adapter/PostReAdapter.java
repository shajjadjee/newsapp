package com.newspaperboot.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.newspaperboot.R;
import com.newspaperboot.model.PostModel;
import com.newspaperboot.service.PostService;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostReAdapter extends RecyclerView.Adapter<PostReAdapter.ViewHolder> {
    Activity context;
    List<PostModel> list;
    PostService postService;
    Uri imageuri;
    LayoutInflater inflater;

    public PostReAdapter(Activity context, List<PostModel> list, Uri imageuri) {
        this.context = context;
        this.list = list;
        this.imageuri = imageuri;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.postgv,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostModel post = list.get(position);
        holder.title.setText(post.getPtitle());

        holder.imageView.setImageURI(imageuri);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            imageView = itemView.findViewById(R.id.imagev);
        }
    }
}

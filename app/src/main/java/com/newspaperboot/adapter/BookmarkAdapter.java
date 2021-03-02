package com.newspaperboot.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.newspaperboot.R;
import com.newspaperboot.bookmark.ListItemClickListener;
import com.newspaperboot.model.BookmarkModel;
import java.util.ArrayList;
import java.util.Random;

public class BookmarkAdapter extends RecyclerView.Adapter<com.newspaperboot.adapter.BookmarkAdapter.ViewHolder> {

Context mContext;
ArrayList<BookmarkModel> mBookmarkList;
    private ListItemClickListener mItemClickListener;


    public BookmarkAdapter(Context mContext, ArrayList<BookmarkModel> mBookmarkList) {
        this.mContext = mContext;
        this.mBookmarkList = mBookmarkList;
    }
    public void setItemClickListener(ListItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark_list, parent, false);
        return new ViewHolder(view, viewType,mItemClickListener);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imagev;
        private TextView tvPostTitle, tvCategoryName, tvPostDate;
        private ImageButton btnBookmark, btnSharePost;
        private RelativeLayout lytContainer;
        private ListItemClickListener itemClickListener;


        public ViewHolder(View itemView, int viewType, ListItemClickListener itemClickListener) {
            super(itemView);

            this.itemClickListener = itemClickListener;
            // Find all views ids
            imagev = (ImageView) itemView.findViewById(R.id.imagev);
            tvPostTitle = (TextView) itemView.findViewById(R.id.title);
            tvCategoryName = (TextView) itemView.findViewById(R.id.category_name);
            tvPostDate = (TextView) itemView.findViewById(R.id.date_text);
            btnBookmark = (ImageButton) itemView.findViewById(R.id.btn_book);
            btnSharePost = (ImageButton) itemView.findViewById(R.id.btn_share);
            lytContainer = (RelativeLayout) itemView.findViewById(R.id.lyt_container);

            btnBookmark.setOnClickListener(this);
            btnSharePost.setOnClickListener(this);
            lytContainer.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(getLayoutPosition(), view);
            }
        }
    }

    @Override
    public int getItemCount() {
        return (null != mBookmarkList ? mBookmarkList.size() : 0);

    }

    @Override
    public void onBindViewHolder(com.newspaperboot.adapter.BookmarkAdapter.ViewHolder mainHolder, int position) {
        final BookmarkModel model = mBookmarkList.get(position);

        // setting data over views
        mainHolder.tvPostTitle.setText(Html.fromHtml(model.getPostTitle()));
        mainHolder.tvCategoryName.setText(Html.fromHtml(model.getPostCategory()));

        String imgUrl = model.getPostImageUrl();
        if (imgUrl != null) {
            Glide.with(mContext)
                    .load(imgUrl)
                    .into(mainHolder.imagev);
        } else {
            Glide.with(mContext)
                    .load(R.color.white)
                    .into(mainHolder.imagev);
        }

        mainHolder.tvPostDate.setText(model.getFormattedDate());

        Random rand = new Random();
        int i = rand.nextInt(5) + 1;


        switch (i) {
            case 1:
                mainHolder.tvCategoryName.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_green));
                break;
            case 2:
                mainHolder.tvCategoryName.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_orange));
                break;
            case 3:
                mainHolder.tvCategoryName.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_pink));
                break;
            case 4:
                mainHolder.tvCategoryName.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_purple));
                break;
            case 5:
                mainHolder.tvCategoryName.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_red));
                break;
            default:
                break;
        }

    }
}
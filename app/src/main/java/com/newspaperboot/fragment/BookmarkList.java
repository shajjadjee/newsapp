package com.newspaperboot.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.newspaperboot.R;
import com.newspaperboot.adapter.BookmarkAdapter;
import com.newspaperboot.bookmark.BookmarkDbController;
import com.newspaperboot.model.BookmarkModel;

import java.util.ArrayList;

public class BookmarkList extends Fragment {

    private ArrayList<BookmarkModel> mBookmarkList;
    private BookmarkAdapter mBookmarkAdapter = null;
    private RecyclerView mRecycler;
    private BookmarkDbController mBookmarkDbController;
    private MenuItem mMenuItemDeleteAll;
    private int mAdapterPosition;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bookmark_list, container, false);
        super.onCreate(savedInstanceState);
        return v;
    }
}
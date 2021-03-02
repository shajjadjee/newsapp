package com.newspaperboot.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.newspaperboot.R;
import com.newspaperboot.RetrofitConf;
import com.newspaperboot.adapter.CatAdapter;
import com.newspaperboot.adapter.PostAdapter;
import com.newspaperboot.model.CatModel;
import com.newspaperboot.model.PostModel;
import com.newspaperboot.service.CatService;
import com.newspaperboot.service.PostService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryFragment extends Fragment {
    CatService catService;
    GridView gv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_category, container, false);
        super.onCreate(savedInstanceState);

        catService = RetrofitConf.createService(CatService.class);
        gv = v.findViewById(R.id.gv);
        Call<List<CatModel>> list = catService.getAll();
        list.enqueue(new Callback<List<CatModel>>() {
            @Override
            public void onResponse(Call<List<CatModel>> call, Response<List<CatModel>> response) {
                List list = response.body();
                if (list != null && list.size() > 0) {
                    showCatlist(list);

                } else {
                    System.out.println("not found====");
                }
            }
            @Override
            public void onFailure(Call<List<CatModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return v;
    }
    private void showCatlist(List<CatModel> list) {
        CatAdapter adapter = new CatAdapter(getActivity(),list);
        gv.setAdapter(adapter);
    }
}
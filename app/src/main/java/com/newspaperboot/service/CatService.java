package com.newspaperboot.service;

import com.newspaperboot.model.CatModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CatService {
    @POST("cat/add")
    public Call<CatModel> add(@Body CatModel catModel);
    @GET("cat/list")
    public Call<List<CatModel>> getAll();
    @GET("cat/one/{id}")
    public Call<CatModel> getById(@Path("id") long id);
    @GET("cat/delete/{id}")
    public Call<CatModel> deleteById(@Path("id") long id);
}

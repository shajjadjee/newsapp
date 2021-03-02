package com.newspaperboot.service;

import com.newspaperboot.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostService {
    @POST("post/add")
    public Call<PostModel> add(@Body PostModel postModel);
    @GET("post/list")
    public Call<List<PostModel>> getAll();
    @GET("post/one/{id}")
    public Call<PostModel> getById(@Path("id") long id);
    @GET("post/list/{cname}")
    public Call<List<PostModel>> getByCat(@Path("cname") String cname);
    @GET("post/delete/{id}")
    public Call<PostModel> deleteById(@Path("id") long id);
}

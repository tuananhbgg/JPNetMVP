package com.example.jpnetmvp.service;


import com.example.jpnetmvp.model.HotNewModel;
import com.example.jpnetmvp.model.BannerModel;
import com.example.jpnetmvp.model.ListNewsModel;
import com.example.jpnetmvp.model.LoginResponseModel;
import com.example.jpnetmvp.model.NewsCategoryResponseModel;
import com.example.jpnetmvp.model.RequestHomeModel;
import com.example.jpnetmvp.model.UserModel;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface IDemoService {

    @POST("user/login")
    Observable<LoginResponseModel> login(@Body UserModel model);

    @POST("banner/get")
    Observable<BannerModel> getListImageBanner(@Body RequestHomeModel model);

    @POST("news/getNewsByAllCategory")
    Observable<NewsCategoryResponseModel> getNewsByAllCategory(@Body RequestHomeModel model);

    @POST("news/getNews")
    Observable<ListNewsModel> getNews(@Body RequestHomeModel model);

    @POST("hot/get")
    Observable<HotNewModel> getHotNew(@Body RequestHomeModel model);

}

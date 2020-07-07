package com.example.jpnetmvp.presenter;


import com.example.jpnetmvp.model.NewsCategoryResponseModel;
import com.example.jpnetmvp.adapter.HomeAdapter;
import com.example.jpnetmvp.model.BannerModel;
import com.example.jpnetmvp.model.HotNewModel;

public interface IHomeFragment {
    void addItemRcvHome(HomeAdapter adapter);

    void loadMore(boolean isLoading);

    void loadSlideImage(BannerModel bannerModels);

    void getHotNew(HotNewModel model, HotNewModel.Body.DiscussQuestion discussQuestion);

    void autoSlideImage(int currentItem);

    void getNewsCategory(NewsCategoryResponseModel newsCategoryResponseModel);




}

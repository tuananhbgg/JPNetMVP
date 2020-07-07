package com.example.jpnetmvp.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.widget.Toast;

import com.example.jpnetmvp.model.NewsCategoryResponseModel;
import com.example.jpnetmvp.adapter.HomeAdapter;
import com.example.jpnetmvp.model.BannerModel;
import com.example.jpnetmvp.model.HotNewModel;
import com.example.jpnetmvp.model.ListNewsModel;
import com.example.jpnetmvp.model.RequestHomeModel;
import com.example.jpnetmvp.service.DemoService;
import com.example.jpnetmvp.service.IDemoService;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class HomePresenter {
    private IHomeFragment iHomeFragment;
    private Context context;
    private Retrofit retrofit;
    private IDemoService iDemoService;
    public CompositeDisposable compositeDisposable;
    public CompositeDisposable disposable;
    private SharedPreferences sharedPreferences;
    private String serverToken;
    private RequestHomeModel requestHomeModel;
    private int pageNumber = 1;
    private int pageSize = 12;
    private int totalItem;


    public HomePresenter(IHomeFragment iHomeFragment, Context context) {
        this.iHomeFragment = iHomeFragment;
        this.context = context;
        retrofit = new DemoService().getInstant();
        iDemoService = retrofit.create(IDemoService.class);
        sharedPreferences = context.getSharedPreferences("SaveServerToken", MODE_PRIVATE);
        serverToken = sharedPreferences.getString("serverToken", "");
        compositeDisposable = new CompositeDisposable();
        disposable = new CompositeDisposable();
    }

    public void addItemRecyclerviewHome(final HomeAdapter adapter, final ArrayList<Object> models) {
        requestHomeModel = new RequestHomeModel(serverToken, 1, pageSize);
//        iDemoService.getNews(requestHomeModel).enqueue(new Callback<ListNewsModel>() {
//            @Override
//            public void onResponse(Call<ListNewsModel> call, Response<ListNewsModel> response) {
//                for (int i = 0; i < response.body().getBody().size(); i++) {
//                    models.add(response.body().getBody().get(i));
//                }
//                adapter.notifyDataSetChanged();
//                iHomeFragment.addItemRcvHome(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<ListNewsModel> call, Throwable t) {
//
//            }
//        });
        compositeDisposable.add(retrofit.create(IDemoService.class)
                .getNews(requestHomeModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ListNewsModel>() {
                    @Override
                    public void accept(ListNewsModel listNewsModel) throws Exception {
                        if (listNewsModel != null) {
                            for (int i = 0; i < listNewsModel.getBody().size(); i++) {
                                models.add(listNewsModel.getBody().get(i));
                            }
                        }
                        iHomeFragment.addItemRcvHome(adapter);
                    }
                }));
    }

    public void loadMore(final HomeAdapter adapter) {
        adapter.getModels().add(7);
        adapter.notifyItemInserted(adapter.getModels().size() - 1);
        adapter.getModels().remove(adapter.getModels().size() - 1);
        int scrollPosition = adapter.getModels().size();
        adapter.notifyItemRemoved(scrollPosition);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                requestHomeModel = new RequestHomeModel(serverToken, pageNumber, pageSize);
                pageNumber = pageNumber + 1;
                requestHomeModel.setPageNumber(pageNumber);
//                iDemoService.getNews(requestHomeModel).enqueue(new Callback<ListNewsModel>() {
//                    @Override
//                    public void onResponse(Call<ListNewsModel> call, Response<ListNewsModel> response) {
//                        if (response.body().getBody().size() > 0) {
//                            for (int i = 0; i < response.body().getBody().size(); i++) {
//                                adapter.getModels().add(response.body().getBody().get(i));
//                            }
//                            adapter.notifyDataSetChanged();
//                            iHomeFragment.loadMore(false);
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ListNewsModel> call, Throwable t) {
//                    }
//                });

                compositeDisposable.add(retrofit.create(IDemoService.class)
                        .getNews(requestHomeModel).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<ListNewsModel>() {
                            @Override
                            public void accept(ListNewsModel listNewsModel) throws Exception {
                                if (listNewsModel != null) {
                                    for (int i = 0; i < listNewsModel.getBody().size(); i++) {
                                        adapter.getModels().add(listNewsModel.getBody().get(i));
                                    }
                                }
                                adapter.notifyDataSetChanged();
                                iHomeFragment.loadMore(false);
                            }
                        }));

            }
        };
        new Handler().postDelayed(runnable, 0);
    }

    public void getListImageBanner() {
        compositeDisposable.add(retrofit.create(IDemoService.class)
                .getListImageBanner(new RequestHomeModel(serverToken, 0, 0))
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<BannerModel>() {
                    @Override
                    public void accept(BannerModel bannerModel) throws Exception {
                        if (bannerModel != null) {
                            totalItem = bannerModel.getBody().size();
                            iHomeFragment.loadSlideImage(bannerModel);
                        }
                    }
                }));

    }

    public void autoSlideImage(final int currentItem) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int nextItem = currentItem + 1;
                if (nextItem == totalItem) {
                    nextItem = 0;
                }
                iHomeFragment.autoSlideImage(nextItem);
                autoSlideImage(nextItem);
            }
        }, 6000);
    }

    public void getNewsCategory() {
        compositeDisposable.add(retrofit.create(IDemoService.class)
                .getNewsByAllCategory(new RequestHomeModel(serverToken, 1, 3))
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<NewsCategoryResponseModel>() {
                    @Override
                    public void accept(NewsCategoryResponseModel newsCategoryResponseModel) throws Exception {
                        if (newsCategoryResponseModel != null) {
                            iHomeFragment.getNewsCategory(newsCategoryResponseModel);
                        }
                    }
                }));
    }

    public void getHotNew() {
        disposable.add(retrofit.create(IDemoService.class)
                .getHotNew(new RequestHomeModel(serverToken, 0, 0))
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<HotNewModel>() {
                    @Override
                    public void accept(HotNewModel hotNewModel) throws Exception {
                        if (hotNewModel != null) {
                            iHomeFragment.getHotNew(hotNewModel, hotNewModel.getBody().getDiscussQuestions().get(0));
                        }
                    }
                }));
    }

}

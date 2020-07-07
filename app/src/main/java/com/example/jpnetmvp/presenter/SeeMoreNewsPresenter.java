package com.example.jpnetmvp.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.example.jpnetmvp.adapter.SeeMoreAdapter;
import com.example.jpnetmvp.model.NewsCategoryResponseModel;
import com.example.jpnetmvp.model.RequestHomeModel;
import com.example.jpnetmvp.presenter.ISeeMoreNewsActivity;
import com.example.jpnetmvp.service.DemoService;
import com.example.jpnetmvp.service.IDemoService;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class SeeMoreNewsPresenter {
    private ISeeMoreNewsActivity iSeeMoreNewsActivity;
    private SharedPreferences sharedPreferences;
    private Context context;
    private String serverToken;
    private Retrofit demoService;
    public CompositeDisposable disposableGetNewByCategory;

    private ArrayList<Object> models;
    private RequestHomeModel requestHomeModel;
    private int pageNumber = 1;
    private int pageSize = 20;

    public SeeMoreNewsPresenter(ISeeMoreNewsActivity iSeeMoreNewsActivity, Context context) {
        this.iSeeMoreNewsActivity = iSeeMoreNewsActivity;
        this.context = context;
        demoService = new DemoService().getInstant();
        disposableGetNewByCategory = new CompositeDisposable();

    }

    public void getNewsByAllCategory(final String theLoaiTin) {
        sharedPreferences = context.getSharedPreferences("SaveServerToken", MODE_PRIVATE);
        serverToken = sharedPreferences.getString("serverToken", "");
        demoService = new DemoService().getInstant();
        requestHomeModel = new RequestHomeModel(serverToken, 1, pageSize);

        models = new ArrayList<>();
        disposableGetNewByCategory.add(demoService.create(IDemoService.class)
                .getNewsByAllCategory(requestHomeModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NewsCategoryResponseModel>() {
                    @Override
                    public void accept(NewsCategoryResponseModel newsCategoryResponseModel) throws Exception {

                        for (int i = 0; i < newsCategoryResponseModel.getBody().size(); i++) {
                            if (newsCategoryResponseModel.getBody().get(i).getCategoryName().equals(theLoaiTin)) {
                                for (int j = 0; j < newsCategoryResponseModel.getBody().get(i).getNews().size(); j++) {
                                    models.add(newsCategoryResponseModel.getBody().get(i).getNews().get(j));
                                }
                            }
                        }
                        iSeeMoreNewsActivity.getNewsByAllCategory(models);
                    }
                }));
    }

    public void loadMore(final String theLoaiTin, SeeMoreAdapter adapter) {
        models = adapter.getModels();
        models.add(1);
        adapter.notifyItemInserted(models.size() - 1);
        models.remove(models.size() - 1);
        int scrollPosition = models.size();
        adapter.notifyItemRemoved(scrollPosition);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                pageNumber = pageNumber + 1;
                requestHomeModel.setPageNumber(pageNumber);
                disposableGetNewByCategory.add(demoService.create(IDemoService.class)
                        .getNewsByAllCategory(requestHomeModel)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<NewsCategoryResponseModel>() {
                            @Override
                            public void accept(NewsCategoryResponseModel newsCategoryResponseModel) throws Exception {
                                if (newsCategoryResponseModel.getBody().size() > 0) {
                                    for (int i = 0; i < newsCategoryResponseModel.getBody().size(); i++) {
                                        if (newsCategoryResponseModel.getBody().get(i).getCategoryName().equals(theLoaiTin)) {
                                            for (int j = 0; j < newsCategoryResponseModel.getBody().get(i).getNews().size(); j++) {
                                                models.add(newsCategoryResponseModel.getBody().get(i).getNews().get(j));
                                            }
                                        }
                                    }
                                }
                                adapter.notifyDataSetChanged();
                                iSeeMoreNewsActivity.loadMore(false);
                            }
                        }));
            }
        };
        new Handler().postDelayed(runnable, 0);
    }

}

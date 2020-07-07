package com.example.jpnetmvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpnetmvp.presenter.HomePresenter;
import com.example.jpnetmvp.presenter.IHomeFragment;
import com.example.jpnetmvp.model.NewsCategoryResponseModel;
import com.example.jpnetmvp.R;
import com.example.jpnetmvp.adapter.HomeAdapter;
import com.example.jpnetmvp.model.BannerModel;
import com.example.jpnetmvp.model.HotNewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment implements IHomeFragment {
    @BindView(R.id.rcvGiaoDienTrangchu)
    RecyclerView rcvGiaoDienTrangchu;
    private LinearLayoutManager manager;
    private HomePresenter homePresenter;
    private boolean isLoading = false;
    private ArrayList<Object> models;
    private HomeAdapter homeAdapter;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        models = new ArrayList<>();
        models.add(0); // item search view
        models.add(1); // item menu
        homePresenter = new HomePresenter(this, getContext());
        manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        rcvGiaoDienTrangchu.setLayoutManager(manager);
        homeAdapter = new HomeAdapter(getContext(), models);
        homePresenter.getListImageBanner();
        rcvGiaoDienTrangchu.setAdapter(homeAdapter);

        rcvGiaoDienTrangchu.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!isLoading) {
                    if (manager != null && manager.findLastCompletelyVisibleItemPosition() == models.size() - 1) {
                        homePresenter.loadMore(homeAdapter);
                        isLoading = true;
                    }
                }
            }
        });
        return view;
    }

    @Override
    public void addItemRcvHome(HomeAdapter adapter) {
        adapter.getModels();
        rcvGiaoDienTrangchu.setAdapter(adapter);
        homePresenter.autoSlideImage(adapter.getCurrenItemSlideImage());
        homeAdapter = adapter;
    }

    @Override
    public void loadMore(boolean load) {
        isLoading = load;

    }

    @Override
    public void loadSlideImage(BannerModel bannerModels) {
        models.add(bannerModels);
        homePresenter.getHotNew();
    }

    @Override
    public void getHotNew(HotNewModel model, HotNewModel.Body.DiscussQuestion discussQuestion) {
        models.add(model);
        models.add(discussQuestion);
        homePresenter.getNewsCategory();
    }

    @Override
    public void autoSlideImage(int currentItem) {
        homeAdapter.slideImageViewHolder.viewpager.setCurrentItem(currentItem);
        homeAdapter.slideImageAdpater.notifyDataSetChanged();
    }

    @Override
    public void getNewsCategory(NewsCategoryResponseModel newsCategoryResponseModel) {
        if (newsCategoryResponseModel != null) {
            models.add(newsCategoryResponseModel);
        }
        homePresenter.addItemRecyclerviewHome(homeAdapter, models);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        homePresenter.compositeDisposable.dispose();
    }
}

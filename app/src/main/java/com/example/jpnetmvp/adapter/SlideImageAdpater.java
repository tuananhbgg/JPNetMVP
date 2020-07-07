package com.example.jpnetmvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.jpnetmvp.R;
import com.example.jpnetmvp.model.BannerModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SlideImageAdpater extends PagerAdapter {


    private ArrayList<BannerModel.Body> lists;

    public ArrayList<BannerModel.Body> getLists() {
        return lists;
    }

    public void setLists(ArrayList<BannerModel.Body> lists) {
        this.lists = lists;
    }

    public SlideImageAdpater(ArrayList<BannerModel.Body> lists) {
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @BindView(R.id.image)
    ImageView image;
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_viewpager, null);
        ButterKnife.bind(this,view);
        Glide.with(container.getContext())
                .load(lists.get(position).getImageUrl())
                .into(image);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}

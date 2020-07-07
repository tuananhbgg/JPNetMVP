package com.example.jpnetmvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jpnetmvp.R;
import com.example.jpnetmvp.model.NewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeeMoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<Object> models;
    private Context context;
    private final int VIEW_TYPE_ITEM_NEW = 0;
    private final int VIEW_TYPE_ITEM_LOADING = 1;

    public ArrayList<Object> getModels() {
        return models;
    }

    public void setModels(ArrayList<Object> models) {
        this.models = models;
    }

    public SeeMoreAdapter(ArrayList<Object> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        if (viewType == VIEW_TYPE_ITEM_NEW) {
            View view = layoutInflater.inflate(R.layout.item_loadmore, parent, false);
            return new SeeMoreViewHoder(view);
        } else if (viewType == VIEW_TYPE_ITEM_LOADING) {
            View view = layoutInflater.inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (models.get(position) instanceof NewModel) {
            return VIEW_TYPE_ITEM_NEW;
        } else if (models.get(position) == (Integer) 1) {
            return VIEW_TYPE_ITEM_LOADING;
        }
        return -1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_ITEM_NEW) {
            SeeMoreViewHoder seeMoreViewHoder = (SeeMoreViewHoder) holder;
            NewModel model = (NewModel) models.get(position);
            if (model.getImagePath() != null) {
                Glide.with(context).load(model.getImagePath()).into(seeMoreViewHoder.imgHotNew);
            } else {
                seeMoreViewHoder.imgHotNew.setImageResource(R.drawable.imgloadmore);
            }
            if (model.getDataType() == 0){
                seeMoreViewHoder.imgPlay.setVisibility(View.GONE);
            }else {
                seeMoreViewHoder.imgPlay.setVisibility(View.VISIBLE);
            }
            seeMoreViewHoder.tvTenTieuDe.setText(model.getTitle());
            seeMoreViewHoder.tvMota.setText(model.getDescription());
            seeMoreViewHoder.tvComment.setText(model.getCommentNumber() + "");

        } else if (getItemViewType(position) == VIEW_TYPE_ITEM_LOADING) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }


    @Override
    public int getItemCount() {
        return models.size();
    }

    class SeeMoreViewHoder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgHotNew)
        ImageView imgHotNew;
        @BindView(R.id.imgPlay)
        ImageView imgPlay;
        @BindView(R.id.tv_TenTieuDe)
        TextView tvTenTieuDe;
        @BindView(R.id.tv_Mota)
        TextView tvMota;
        @BindView(R.id.tv_TrangThai)
        TextView tvTrangThai;
        @BindView(R.id.imgComment)
        ImageView imgComment;
        @BindView(R.id.tvComment)
        TextView tvComment;

        public SeeMoreViewHoder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class LoadingViewHolder extends RecyclerView.ViewHolder {
        private ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }
}

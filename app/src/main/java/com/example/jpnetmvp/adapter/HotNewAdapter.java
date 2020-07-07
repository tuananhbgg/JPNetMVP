package com.example.jpnetmvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jpnetmvp.R;
import com.example.jpnetmvp.model.HotNewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotNewAdapter extends RecyclerView.Adapter<HotNewAdapter.HotNewViewHolder> {

    private ArrayList<HotNewModel.Body.HotNews> models;
    private Context context;

    public HotNewAdapter(ArrayList<HotNewModel.Body.HotNews> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public HotNewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, null);
        return new HotNewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotNewViewHolder holder, int position) {
        HotNewModel.Body.HotNews.News news = models.get(position).getNews();
        if (news.getImagePath() != null) {
            Glide.with(context).load(news.getImagePath()).into(holder.imgHotNew);
        }
        holder.tvTenTieuDe.setText(news.getTitle());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class HotNewViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgHotNew)
        ImageView imgHotNew;
        @BindView(R.id.tv_TenTieuDe)
        TextView tvTenTieuDe;
        @BindView(R.id.tv_Trangthai)
        TextView tvTrangthai;

        public HotNewViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

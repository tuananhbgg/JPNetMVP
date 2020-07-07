package com.example.jpnetmvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jpnetmvp.R;
import com.example.jpnetmvp.model.NewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.TinTucViewHodel> {


    private ArrayList<NewModel> models;
    private Context context;

    public NewAdapter(ArrayList<NewModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public TinTucViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new_horizontal, null);
        return new TinTucViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TinTucViewHodel holder, int position) {
        NewModel model = models.get(position);
        if (model.getImagePath() != null) {
            Glide.with(context).load(model.getImagePath()).into(holder.imgNew);
        }
        holder.tvComment.setText(model.getCommentNumber() + "");
        holder.tvTitle.setText(model.getTitle());
        if (model.getDataType() == 0) {
            holder.imgPlay.setVisibility(View.GONE);
        } else {
            holder.imgPlay.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class TinTucViewHodel extends RecyclerView.ViewHolder {
        @BindView(R.id.line)
        View line;
        @BindView(R.id.imgNew)
        ImageView imgNew;
        @BindView(R.id.imgPlay)
        ImageView imgPlay;
        @BindView(R.id.cv_tintuc)
        CardView cvTintuc;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvTrangthai)
        TextView tvTrangthai;
        @BindView(R.id.imgComment)
        ImageView imgComment;
        @BindView(R.id.tvComment)
        TextView tvComment;

        public TinTucViewHodel(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}


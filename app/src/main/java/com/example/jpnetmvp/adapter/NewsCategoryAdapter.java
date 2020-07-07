package com.example.jpnetmvp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpnetmvp.model.NewsCategoryResponseModel;
import com.example.jpnetmvp.model.NewModel;
import com.example.jpnetmvp.R;
import com.example.jpnetmvp.view.SeeMoreNewsActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsCategoryAdapter extends RecyclerView.Adapter<NewsCategoryAdapter.NewsCategoryViewHolder> {

    private ArrayList<NewsCategoryResponseModel.Body> models;
    private Context context;

    public NewsCategoryAdapter(ArrayList<NewsCategoryResponseModel.Body> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public NewsCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_newscategory, null);
        return new NewsCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsCategoryViewHolder holder, final int position) {
        holder.tvNewsCategory.setText(models.get(position).getCategoryName());
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL);
        holder.rcvNewsCateGory.setLayoutManager(manager);
        ArrayList<NewModel> lists = (ArrayList<NewModel>) models.get(position).getNews();
        NewAdapter adapter = new NewAdapter(lists);
        holder.rcvNewsCateGory.setAdapter(adapter);
        holder.btnNewsCategory.setText("xem thêm");
        holder.btnNewsCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SeeMoreNewsActivity.class);
                intent.putExtra("theLoaiTinTuc", models.get(position).getCategoryName());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class NewsCategoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvNewsCategory)
        TextView tvNewsCategory;
        @BindView(R.id.rcvNewsCateGory)
        RecyclerView rcvNewsCateGory;
        @BindView(R.id.btnNewsCategory)
        Button btnNewsCategory;
        public NewsCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);


        }
    }
}

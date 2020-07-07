package com.example.jpnetmvp.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpnetmvp.R;
import com.example.jpnetmvp.presenter.SeeMoreNewsPresenter;
import com.example.jpnetmvp.adapter.SeeMoreAdapter;
import com.example.jpnetmvp.presenter.ISeeMoreNewsActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeeMoreNewsActivity extends AppCompatActivity implements ISeeMoreNewsActivity {
    @BindView(R.id.tvToolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rcvSeeMoreNews)
    RecyclerView rcvSeeMoreNews;
    private SeeMoreNewsPresenter seeMoreNewsPresenter;
    private boolean isLoading = false;
    private ArrayList<Object> models;
    private String THE_LOAI_TIN;
    private SeeMoreAdapter seeMoreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_more_news);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        THE_LOAI_TIN = getIntent().getStringExtra("theLoaiTinTuc");
        String textToolBar = THE_LOAI_TIN;
        String text = textToolBar.toLowerCase();
        tvToolbar.setText(text);
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        rcvSeeMoreNews.setLayoutManager(manager);
        seeMoreNewsPresenter = new SeeMoreNewsPresenter(this, this);
        seeMoreNewsPresenter.getNewsByAllCategory(THE_LOAI_TIN);
        rcvSeeMoreNews.setAdapter(seeMoreAdapter);

        rcvSeeMoreNews.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!isLoading) {
                    if (manager != null && manager.findLastCompletelyVisibleItemPosition() == models.size() - 1) {
                        seeMoreNewsPresenter.loadMore(THE_LOAI_TIN, seeMoreAdapter);
                        isLoading = true;
                    }

                }
            }
        });

    }

    @Override
    public void getNewsByAllCategory(ArrayList<Object> lists) {
        models = lists;
        seeMoreAdapter = new SeeMoreAdapter(lists);
        rcvSeeMoreNews.setAdapter(seeMoreAdapter);
    }

    @Override
    public void loadMore(boolean isLoad) {
        isLoading = isLoad;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        seeMoreNewsPresenter.disposableGetNewByCategory.dispose();
    }
}

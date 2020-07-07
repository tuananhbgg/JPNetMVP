package com.example.jpnetmvp.adapter;

import android.content.Context;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.jpnetmvp.R;
import com.example.jpnetmvp.model.BannerModel;
import com.example.jpnetmvp.model.HotNewModel;
import com.example.jpnetmvp.model.NewModel;
import com.example.jpnetmvp.model.NewsCategoryResponseModel;


import org.apache.commons.lang3.StringEscapeUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private int currenItemSlideImage;
    private ArrayList<Object> models;


    public int getCurrenItemSlideImage() {
        return currenItemSlideImage;
    }

    public ArrayList<Object> getModels() {
        return models;
    }

    public HomeAdapter(Context context, ArrayList<Object> models) {
        this.context = context;
        this.models = models;
    }

    private LinearLayoutManager managerH, managerV;
    public SlideImageAdpater slideImageAdpater;
    public SlideImageViewHolder slideImageViewHolder;

    private final int VIEW_TYPE_ITEM_SEARCH = 0;
    private final int VIEW_TYPE_ITEM_MENU = 1;
    private final int VIEW_TYPE_ITEM_SLIDEIMAGE = 2;
    private final int VIEW_TYPE_ITEM_HOTNEWS = 3;
    private final int VIEW_TYPE_ITEM_QUESTIONNEEDHELP = 4;
    private final int VIEW_TYPE_ITEM_NEW_CATEGORY = 5;
    private final int VIEW_TYPE_ITEM_LOADMORE = 6;
    private final int VIEW_TYPE_ITEM_LOADING = 7;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == VIEW_TYPE_ITEM_SEARCH) {
            View viewSearch = layoutInflater.inflate(R.layout.searchview, parent, false);
            return new SearchViewHolder(viewSearch);
        } else if (viewType == VIEW_TYPE_ITEM_MENU) {
            View viewMenu = layoutInflater.inflate(R.layout.menu, parent, false);
            return new MenuViewHolder(viewMenu);
        } else if (viewType == VIEW_TYPE_ITEM_SLIDEIMAGE) {
            View viewSlideImage = layoutInflater.inflate(R.layout.slideimage, parent, false);
            return new SlideImageViewHolder(viewSlideImage);
        } else if (viewType == VIEW_TYPE_ITEM_HOTNEWS) {
            View viewHotNews = layoutInflater.inflate(R.layout.hotnews, parent, false);
            return new HotNewsViewHolder(viewHotNews);
        } else if (viewType == VIEW_TYPE_ITEM_QUESTIONNEEDHELP) {
            View view = layoutInflater.inflate(R.layout.questionsneedhelp, parent, false);
            return new QuestionsNeedHelpViewHolder(view);
        } else if (viewType == VIEW_TYPE_ITEM_NEW_CATEGORY) {
            View view = layoutInflater.inflate(R.layout.newscategory, parent, false);
            return new NewsCategoryViewHolder(view);
        } else if (viewType == VIEW_TYPE_ITEM_LOADMORE) {
            View view = layoutInflater.inflate(R.layout.item_loadmore, parent, false);
            return new LoadModeViewHolder(view);
        } else if (viewType == VIEW_TYPE_ITEM_LOADING) {
            View view = layoutInflater.inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (models.get(position) == (Integer) 0) {
            return VIEW_TYPE_ITEM_SEARCH;
        } else if (models.get(position) == (Integer) 1) {
            return VIEW_TYPE_ITEM_MENU;
        } else if (models.get(position) instanceof BannerModel) {
            return VIEW_TYPE_ITEM_SLIDEIMAGE;
        } else if (models.get(position) instanceof HotNewModel) {
            return VIEW_TYPE_ITEM_HOTNEWS;
        } else if (models.get(position) instanceof HotNewModel.Body.DiscussQuestion) {
            return VIEW_TYPE_ITEM_QUESTIONNEEDHELP;
        } else if (models.get(position) instanceof NewsCategoryResponseModel) {
            return VIEW_TYPE_ITEM_NEW_CATEGORY;
        } else if (models.get(position) == (Integer) 9) {
            return VIEW_TYPE_ITEM_LOADING;
        } else if (models.get(position) instanceof NewModel) {
            return VIEW_TYPE_ITEM_LOADMORE;
        }
        return -1;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_ITEM_SEARCH) {

        } else if (getItemViewType(position) == VIEW_TYPE_ITEM_MENU) {

        } else if (getItemViewType(position) == VIEW_TYPE_ITEM_SLIDEIMAGE) {
            slideImageViewHolder = (SlideImageViewHolder) holder;
            BannerModel bannerModel = (BannerModel) models.get(position);
            slideImageAdpater = new SlideImageAdpater((ArrayList<BannerModel.Body>) bannerModel.getBody());
            slideImageViewHolder.viewpager.setAdapter(slideImageAdpater);
            slideImageViewHolder.circleIndicator.setViewPager(slideImageViewHolder.viewpager);
            slideImageViewHolder.viewpager.setCurrentItem(currenItemSlideImage);

        } else if (getItemViewType(position) == VIEW_TYPE_ITEM_HOTNEWS) {
            HotNewsViewHolder hotNewsViewHolder = (HotNewsViewHolder) holder;
            managerH = new LinearLayoutManager(context);
            managerH.setOrientation(RecyclerView.HORIZONTAL);
            hotNewsViewHolder.rcvTinNoiBat.setLayoutManager(managerH);
            HotNewModel model = (HotNewModel) models.get(position);
            HotNewAdapter hotNewAdapter = new HotNewAdapter((ArrayList<HotNewModel.Body.HotNews>) model.getBody().getHotNews());
            hotNewsViewHolder.rcvTinNoiBat.setAdapter(hotNewAdapter);

        } else if (getItemViewType(position) == VIEW_TYPE_ITEM_QUESTIONNEEDHELP) {
            QuestionsNeedHelpViewHolder questionsNeedHelpViewHolder = (QuestionsNeedHelpViewHolder) holder;
            HotNewModel.Body.DiscussQuestion discussQuestion = (HotNewModel.Body.DiscussQuestion) models.get(position);
            Glide.with(context).load(discussQuestion.getOwnerAvatar()).into(questionsNeedHelpViewHolder.imgAvatar);
            String question = StringEscapeUtils.unescapeJava(discussQuestion.getContent());
            questionsNeedHelpViewHolder.tvCauHoi.setText(question);
            questionsNeedHelpViewHolder.tvName.setText(discussQuestion.getOwnerName());


        } else if (getItemViewType(position) == VIEW_TYPE_ITEM_NEW_CATEGORY) {
            NewsCategoryViewHolder newsCategoryViewHolder = (NewsCategoryViewHolder) holder;
            managerV = new LinearLayoutManager(context);
            managerV.setOrientation(RecyclerView.VERTICAL);
            newsCategoryViewHolder.rcvNewsCateGory.setLayoutManager(managerV);
            NewsCategoryResponseModel responseModel = (NewsCategoryResponseModel) models.get(position);
            ArrayList<NewsCategoryResponseModel.Body> listNews;
            listNews = (ArrayList<NewsCategoryResponseModel.Body>) responseModel.getBody();
            listNews.size();
            NewsCategoryAdapter adapter = new NewsCategoryAdapter(listNews);
            newsCategoryViewHolder.rcvNewsCateGory.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        } else if (getItemViewType(position) == VIEW_TYPE_ITEM_LOADMORE) {
            LoadModeViewHolder loadModeViewHolder = (LoadModeViewHolder) holder;
            NewModel model = (NewModel) models.get(position);

            if (model.getImagePath() != null) {
                Glide.with(context).load(model.getImagePath()).into(loadModeViewHolder.imgHotNew);
            } else {
                loadModeViewHolder.imgHotNew.setImageResource(R.drawable.imgloadmore);
            }
            loadModeViewHolder.tvTenTieuDe.setText(model.getTitle());
            loadModeViewHolder.tvMota.setText(model.getDescription());
            loadModeViewHolder.tvComment.setText(model.getCommentNumber() + "");
            if (model.getDataType() == 0) {
                loadModeViewHolder.imgPlay.setVisibility(View.GONE);
            } else {
                loadModeViewHolder.imgPlay.setVisibility(View.VISIBLE);
            }


        } else if (getItemViewType(position) == VIEW_TYPE_ITEM_LOADING) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }

    }


    @Override
    public int getItemCount() {
        return models.size();
    }


    public class SearchViewHolder extends RecyclerView.ViewHolder {

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

    public class SlideImageViewHolder extends RecyclerView.ViewHolder {

        public ViewPager viewpager;
        @BindView(R.id.circleIndicator)
        CircleIndicator circleIndicator;

        public SlideImageViewHolder(View itemView) {
            super(itemView);
            viewpager = itemView.findViewById(R.id.viewpager);
            ButterKnife.bind(this, itemView);
        }
    }

    public class HotNewsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rcvTinNoiBat)
        RecyclerView rcvTinNoiBat;

        public HotNewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class QuestionsNeedHelpViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_avatar)
        ImageView imgAvatar;
        @BindView(R.id.cvImg)
        CardView cvImg;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvTG)
        TextView tvTG;
        @BindView(R.id.tvCauHoi)
        TextView tvCauHoi;
        @BindView(R.id.btnTraLoi)
        Button btnTraLoi;

        public QuestionsNeedHelpViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class NewsCategoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rcvNewsCateGory)
        RecyclerView rcvNewsCateGory;

        public NewsCategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public class LoadModeViewHolder extends RecyclerView.ViewHolder {
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

        public LoadModeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.progressBar)
        ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    String serverResponse = "SOME RESPONSE FROM SERVER WITH UNICODE CHARACTERS";
    String fromServerUnicodeDecoded = StringEscapeUtils.unescapeJava(serverResponse);
}


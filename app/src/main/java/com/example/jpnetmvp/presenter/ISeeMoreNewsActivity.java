package com.example.jpnetmvp.presenter;

import java.util.ArrayList;

public interface ISeeMoreNewsActivity {
    void getNewsByAllCategory(ArrayList<Object> models);
    void loadMore(boolean isLoad);
}

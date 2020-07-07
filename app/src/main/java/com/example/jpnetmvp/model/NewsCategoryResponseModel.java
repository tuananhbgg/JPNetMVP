package com.example.jpnetmvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class NewsCategoryResponseModel {

    public class Body {
        @SerializedName("category")
        @Expose
        private Integer category;
        @SerializedName("categoryName")
        @Expose
        private String categoryName;
        @SerializedName("news")
        @Expose
        private List<NewModel> news = null;

        public Integer getCategory() {
            return category;
        }

        public void setCategory(Integer category) {
            this.category = category;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public List<NewModel> getNews() {
            return news;
        }

        public void setNews(List<NewModel> news) {
            this.news = news;
        }
    }

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("body")
    @Expose
    private List<Body> body = null;
    @SerializedName("message")
    @Expose
    private Object message;
    @SerializedName("totalRecords")
    @Expose
    private Integer totalRecords;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Body> getBody() {
        return body;
    }

    public void setBody(List<Body> body) {
        this.body = body;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

}





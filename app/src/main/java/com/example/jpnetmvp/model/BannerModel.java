package com.example.jpnetmvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BannerModel {
    public class Body {
        @SerializedName("delYn")
        @Expose
        private String delYn;
        @SerializedName("createdTime")
        @Expose
        private String createdTime;
        @SerializedName("editedTime")
        @Expose
        private String editedTime;
        @SerializedName("uniqueId")
        @Expose
        private Integer uniqueId;
        @SerializedName("ownerId")
        @Expose
        private Integer ownerId;
        @SerializedName("title")
        @Expose
        private Object title;
        @SerializedName("content")
        @Expose
        private Object content;
        @SerializedName("functionId")
        @Expose
        private Integer functionId;
        @SerializedName("imageUrl")
        @Expose
        private String imageUrl;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("objectId")
        @Expose
        private Integer objectId;

        public String getDelYn() {
            return delYn;
        }

        public void setDelYn(String delYn) {
            this.delYn = delYn;
        }

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public String getEditedTime() {
            return editedTime;
        }

        public void setEditedTime(String editedTime) {
            this.editedTime = editedTime;
        }

        public Integer getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(Integer uniqueId) {
            this.uniqueId = uniqueId;
        }

        public Integer getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(Integer ownerId) {
            this.ownerId = ownerId;
        }

        public Object getTitle() {
            return title;
        }

        public void setTitle(Object title) {
            this.title = title;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public Integer getFunctionId() {
            return functionId;
        }

        public void setFunctionId(Integer functionId) {
            this.functionId = functionId;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getObjectId() {
            return objectId;
        }

        public void setObjectId(Integer objectId) {
            this.objectId = objectId;
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

package com.example.jpnetmvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewModel {
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
    @SerializedName("siteId")
    @Expose
    private Integer siteId;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("referenceId")
    @Expose
    private Object referenceId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imagePath")
    @Expose
    private Object imagePath;
    @SerializedName("videoUrl")
    @Expose
    private Object videoUrl;
    @SerializedName("publishedTimeTemp")
    @Expose
    private Object publishedTimeTemp;
    @SerializedName("publishedTime")
    @Expose
    private String publishedTime;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("category")
    @Expose
    private Integer category;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("catalogId")
    @Expose
    private Integer catalogId;
    @SerializedName("ownerId")
    @Expose
    private Integer ownerId;
    @SerializedName("dataType")
    @Expose
    private Integer dataType;
    @SerializedName("ownerName")
    @Expose
    private Object ownerName;
    @SerializedName("catalogName")
    @Expose
    private String catalogName;
    @SerializedName("likeNumber")
    @Expose
    private Integer likeNumber;
    @SerializedName("commentNumber")
    @Expose
    private Integer commentNumber;
    @SerializedName("siteName")
    @Expose
    private Object siteName;
    @SerializedName("randomNumber")
    @Expose
    private Double randomNumber;
    @SerializedName("sharingNumber")
    @Expose
    private Integer sharingNumber;
    @SerializedName("favoriteNumber")
    @Expose
    private Integer favoriteNumber;
    @SerializedName("likedByCurrentUser")
    @Expose
    private Boolean likedByCurrentUser;
    @SerializedName("hot")
    @Expose
    private Boolean hot;

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

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Object referenceId) {
        this.referenceId = referenceId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getImagePath() {
        return imagePath;
    }

    public void setImagePath(Object imagePath) {
        this.imagePath = imagePath;
    }

    public Object getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(Object videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Object getPublishedTimeTemp() {
        return publishedTimeTemp;
    }

    public void setPublishedTimeTemp(Object publishedTimeTemp) {
        this.publishedTimeTemp = publishedTimeTemp;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Object getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(Object ownerName) {
        this.ownerName = ownerName;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    public Object getSiteName() {
        return siteName;
    }

    public void setSiteName(Object siteName) {
        this.siteName = siteName;
    }

    public Double getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Double randomNumber) {
        this.randomNumber = randomNumber;
    }

    public Integer getSharingNumber() {
        return sharingNumber;
    }

    public void setSharingNumber(Integer sharingNumber) {
        this.sharingNumber = sharingNumber;
    }

    public Integer getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(Integer favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public Boolean getLikedByCurrentUser() {
        return likedByCurrentUser;
    }

    public void setLikedByCurrentUser(Boolean likedByCurrentUser) {
        this.likedByCurrentUser = likedByCurrentUser;
    }

    public Boolean getHot() {
        return hot;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }


}

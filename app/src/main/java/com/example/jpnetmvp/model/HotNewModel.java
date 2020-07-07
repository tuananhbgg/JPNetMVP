package com.example.jpnetmvp.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotNewModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("body")
    @Expose
    private Body body;
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

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
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

   public class Body {

        @SerializedName("hotNews")
        @Expose
        private List<HotNews> hotNews = null;
        @SerializedName("discussQuestions")
        @Expose
        private List<DiscussQuestion> discussQuestions = null;
        @SerializedName("news")
        @Expose
        private Object news;
        @SerializedName("videoItemResponses")
        @Expose
        private Object videoItemResponses;

        public List<HotNews> getHotNews() {
            return hotNews;
        }

        public void setHotNews(List<HotNews> hotNews) {
            this.hotNews = hotNews;
        }

        public List<DiscussQuestion> getDiscussQuestions() {
            return discussQuestions;
        }

        public void setDiscussQuestions(List<DiscussQuestion> discussQuestions) {
            this.discussQuestions = discussQuestions;
        }

        public Object getNews() {
            return news;
        }

        public void setNews(Object news) {
            this.news = news;
        }

        public Object getVideoItemResponses() {
            return videoItemResponses;
        }

        public void setVideoItemResponses(Object videoItemResponses) {
            this.videoItemResponses = videoItemResponses;
        }

       public class HotNews {

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
            @SerializedName("objectId")
            @Expose
            private Integer objectId;
            @SerializedName("hotNewsType")
            @Expose
            private Integer hotNewsType;
            @SerializedName("startTime")
            @Expose
            private Object startTime;
            @SerializedName("endTime")
            @Expose
            private Object endTime;
            @SerializedName("news")
            @Expose
            private News news;
            @SerializedName("discussQuestion")
            @Expose
            private Object discussQuestion;
            @SerializedName("job")
            @Expose
            private Object job;
            @SerializedName("order")
            @Expose
            private Object order;
            @SerializedName("video")
            @Expose
            private Object video;
            @SerializedName("data")
            @Expose
            private Object data;

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

           public Integer getObjectId() {
               return objectId;
           }

           public void setObjectId(Integer objectId) {
               this.objectId = objectId;
           }

           public Integer getHotNewsType() {
               return hotNewsType;
           }

           public void setHotNewsType(Integer hotNewsType) {
               this.hotNewsType = hotNewsType;
           }

           public Object getStartTime() {
               return startTime;
           }

           public void setStartTime(Object startTime) {
               this.startTime = startTime;
           }

           public Object getEndTime() {
               return endTime;
           }

           public void setEndTime(Object endTime) {
               this.endTime = endTime;
           }

           public News getNews() {
               return news;
           }

           public void setNews(News news) {
               this.news = news;
           }

           public Object getDiscussQuestion() {
               return discussQuestion;
           }

           public void setDiscussQuestion(Object discussQuestion) {
               this.discussQuestion = discussQuestion;
           }

           public Object getJob() {
               return job;
           }

           public void setJob(Object job) {
               this.job = job;
           }

           public Object getOrder() {
               return order;
           }

           public void setOrder(Object order) {
               this.order = order;
           }

           public Object getVideo() {
               return video;
           }

           public void setVideo(Object video) {
               this.video = video;
           }

           public Object getData() {
               return data;
           }

           public void setData(Object data) {
               this.data = data;
           }

           public class News {

                @SerializedName("delYn")
                @Expose
                private Object delYn;
                @SerializedName("createdTime")
                @Expose
                private String createdTime;
                @SerializedName("editedTime")
                @Expose
                private Object editedTime;
                @SerializedName("uniqueId")
                @Expose
                private Integer uniqueId;
                @SerializedName("siteId")
                @Expose
                private Object siteId;
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
                private String imagePath;
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
                private Object catalogId;
                @SerializedName("ownerId")
                @Expose
                private Object ownerId;
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

                public Object getDelYn() {
                    return delYn;
                }

                public void setDelYn(Object delYn) {
                    this.delYn = delYn;
                }

                public String getCreatedTime() {
                    return createdTime;
                }

                public void setCreatedTime(String createdTime) {
                    this.createdTime = createdTime;
                }

                public Object getEditedTime() {
                    return editedTime;
                }

                public void setEditedTime(Object editedTime) {
                    this.editedTime = editedTime;
                }

                public Integer getUniqueId() {
                    return uniqueId;
                }

                public void setUniqueId(Integer uniqueId) {
                    this.uniqueId = uniqueId;
                }

                public Object getSiteId() {
                    return siteId;
                }

                public void setSiteId(Object siteId) {
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

                public String getImagePath() {
                    return imagePath;
                }

                public void setImagePath(String imagePath) {
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

                public Object getCatalogId() {
                    return catalogId;
                }

                public void setCatalogId(Object catalogId) {
                    this.catalogId = catalogId;
                }

                public Object getOwnerId() {
                    return ownerId;
                }

                public void setOwnerId(Object ownerId) {
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

        }

       public class DiscussQuestion {

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
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("content")
            @Expose
            private String content;
            @SerializedName("catalogId")
            @Expose
            private Integer catalogId;
            @SerializedName("ownerId")
            @Expose
            private Integer ownerId;
            @SerializedName("status")
            @Expose
            private Integer status;
            @SerializedName("discussType")
            @Expose
            private Integer discussType;
            @SerializedName("publishedTime")
            @Expose
            private String publishedTime;
            @SerializedName("createdDate")
            @Expose
            private String createdDate;
            @SerializedName("likeNumber")
            @Expose
            private Integer likeNumber;
            @SerializedName("commentNumber")
            @Expose
            private Integer commentNumber;
            @SerializedName("catalogName")
            @Expose
            private String catalogName;
            @SerializedName("ownerName")
            @Expose
            private String ownerName;
            @SerializedName("ownerAvatar")
            @Expose
            private String ownerAvatar;
            @SerializedName("latestCommentDate")
            @Expose
            private Object latestCommentDate;
            @SerializedName("optionsVoting")
            @Expose
            private List<Object> optionsVoting = null;
            @SerializedName("imageUrl")
            @Expose
            private String imageUrl;
            @SerializedName("last_comment")
            @Expose
            private String lastComment;
            @SerializedName("userReportName")
            @Expose
            private Object userReportName;
            @SerializedName("userReportAvatar")
            @Expose
            private Object userReportAvatar;
            @SerializedName("numVote")
            @Expose
            private Integer numVote;
            @SerializedName("comments")
            @Expose
            private List<Comment> comments = null;
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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
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

            public Integer getStatus() {
                return status;
            }

            public void setStatus(Integer status) {
                this.status = status;
            }

            public Integer getDiscussType() {
                return discussType;
            }

            public void setDiscussType(Integer discussType) {
                this.discussType = discussType;
            }

            public String getPublishedTime() {
                return publishedTime;
            }

            public void setPublishedTime(String publishedTime) {
                this.publishedTime = publishedTime;
            }

            public String getCreatedDate() {
                return createdDate;
            }

            public void setCreatedDate(String createdDate) {
                this.createdDate = createdDate;
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

            public String getCatalogName() {
                return catalogName;
            }

            public void setCatalogName(String catalogName) {
                this.catalogName = catalogName;
            }

            public String getOwnerName() {
                return ownerName;
            }

            public void setOwnerName(String ownerName) {
                this.ownerName = ownerName;
            }

            public String getOwnerAvatar() {
                return ownerAvatar;
            }

            public void setOwnerAvatar(String ownerAvatar) {
                this.ownerAvatar = ownerAvatar;
            }

            public Object getLatestCommentDate() {
                return latestCommentDate;
            }

            public void setLatestCommentDate(Object latestCommentDate) {
                this.latestCommentDate = latestCommentDate;
            }

            public List<Object> getOptionsVoting() {
                return optionsVoting;
            }

            public void setOptionsVoting(List<Object> optionsVoting) {
                this.optionsVoting = optionsVoting;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getLastComment() {
                return lastComment;
            }

            public void setLastComment(String lastComment) {
                this.lastComment = lastComment;
            }

            public Object getUserReportName() {
                return userReportName;
            }

            public void setUserReportName(Object userReportName) {
                this.userReportName = userReportName;
            }

            public Object getUserReportAvatar() {
                return userReportAvatar;
            }

            public void setUserReportAvatar(Object userReportAvatar) {
                this.userReportAvatar = userReportAvatar;
            }

            public Integer getNumVote() {
                return numVote;
            }

            public void setNumVote(Integer numVote) {
                this.numVote = numVote;
            }

            public List<Comment> getComments() {
                return comments;
            }

            public void setComments(List<Comment> comments) {
                this.comments = comments;
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

            class Comment {

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
                @SerializedName("objectId")
                @Expose
                private Integer objectId;
                @SerializedName("type")
                @Expose
                private Integer type;
                @SerializedName("content")
                @Expose
                private String content;
                @SerializedName("ownerId")
                @Expose
                private Integer ownerId;
                @SerializedName("parentCommentId")
                @Expose
                private Integer parentCommentId;
                @SerializedName("likeNumber")
                @Expose
                private Integer likeNumber;
                @SerializedName("subCommentList")
                @Expose
                private Object subCommentList;
                @SerializedName("ownerName")
                @Expose
                private String ownerName;
                @SerializedName("ownerAvatarUrl")
                @Expose
                private String ownerAvatarUrl;
                @SerializedName("objectContent")
                @Expose
                private Object objectContent;
                @SerializedName("parentComment")
                @Expose
                private Object parentComment;
                @SerializedName("ratingId")
                @Expose
                private Integer ratingId;
                @SerializedName("ratingValue")
                @Expose
                private Integer ratingValue;
                @SerializedName("relativeId")
                @Expose
                private Integer relativeId;
                @SerializedName("relativeName")
                @Expose
                private String relativeName;
                @SerializedName("relativeAvatarUrl")
                @Expose
                private String relativeAvatarUrl;
                @SerializedName("imageUrl")
                @Expose
                private String imageUrl;
                @SerializedName("hide")
                @Expose
                private Boolean hide;
                @SerializedName("likedByCurrentUser")
                @Expose
                private Boolean likedByCurrentUser;

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

                public Integer getObjectId() {
                    return objectId;
                }

                public void setObjectId(Integer objectId) {
                    this.objectId = objectId;
                }

                public Integer getType() {
                    return type;
                }

                public void setType(Integer type) {
                    this.type = type;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public Integer getOwnerId() {
                    return ownerId;
                }

                public void setOwnerId(Integer ownerId) {
                    this.ownerId = ownerId;
                }

                public Integer getParentCommentId() {
                    return parentCommentId;
                }

                public void setParentCommentId(Integer parentCommentId) {
                    this.parentCommentId = parentCommentId;
                }

                public Integer getLikeNumber() {
                    return likeNumber;
                }

                public void setLikeNumber(Integer likeNumber) {
                    this.likeNumber = likeNumber;
                }

                public Object getSubCommentList() {
                    return subCommentList;
                }

                public void setSubCommentList(Object subCommentList) {
                    this.subCommentList = subCommentList;
                }

                public String getOwnerName() {
                    return ownerName;
                }

                public void setOwnerName(String ownerName) {
                    this.ownerName = ownerName;
                }

                public String getOwnerAvatarUrl() {
                    return ownerAvatarUrl;
                }

                public void setOwnerAvatarUrl(String ownerAvatarUrl) {
                    this.ownerAvatarUrl = ownerAvatarUrl;
                }

                public Object getObjectContent() {
                    return objectContent;
                }

                public void setObjectContent(Object objectContent) {
                    this.objectContent = objectContent;
                }

                public Object getParentComment() {
                    return parentComment;
                }

                public void setParentComment(Object parentComment) {
                    this.parentComment = parentComment;
                }

                public Integer getRatingId() {
                    return ratingId;
                }

                public void setRatingId(Integer ratingId) {
                    this.ratingId = ratingId;
                }

                public Integer getRatingValue() {
                    return ratingValue;
                }

                public void setRatingValue(Integer ratingValue) {
                    this.ratingValue = ratingValue;
                }

                public Integer getRelativeId() {
                    return relativeId;
                }

                public void setRelativeId(Integer relativeId) {
                    this.relativeId = relativeId;
                }

                public String getRelativeName() {
                    return relativeName;
                }

                public void setRelativeName(String relativeName) {
                    this.relativeName = relativeName;
                }

                public String getRelativeAvatarUrl() {
                    return relativeAvatarUrl;
                }

                public void setRelativeAvatarUrl(String relativeAvatarUrl) {
                    this.relativeAvatarUrl = relativeAvatarUrl;
                }

                public String getImageUrl() {
                    return imageUrl;
                }

                public void setImageUrl(String imageUrl) {
                    this.imageUrl = imageUrl;
                }

                public Boolean getHide() {
                    return hide;
                }

                public void setHide(Boolean hide) {
                    this.hide = hide;
                }

                public Boolean getLikedByCurrentUser() {
                    return likedByCurrentUser;
                }

                public void setLikedByCurrentUser(Boolean likedByCurrentUser) {
                    this.likedByCurrentUser = likedByCurrentUser;
                }

            }
        }
    }

}

package com.example.jpnetmvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponseModel {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("body")
    @Expose
    private Body body;
    @SerializedName("message")
    @Expose
    private String message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }
    public class Body {

        @SerializedName("delYn")
        @Expose
        private Object delYn;
        @SerializedName("createdTime")
        @Expose
        private Object createdTime;
        @SerializedName("editedTime")
        @Expose
        private Object editedTime;
        @SerializedName("uniqueId")
        @Expose
        private Integer uniqueId;
        @SerializedName("userName")
        @Expose
        private String userName;
        @SerializedName("password")
        @Expose
        private Object password;
        @SerializedName("fullName")
        @Expose
        private String fullName;
        @SerializedName("accountName")
        @Expose
        private String accountName;
        @SerializedName("socialPassword")
        @Expose
        private Object socialPassword;
        @SerializedName("birthday")
        @Expose
        private Object birthday;
        @SerializedName("gender")
        @Expose
        private Integer gender;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("cellPhone")
        @Expose
        private String cellPhone;
        @SerializedName("japaneseLevel")
        @Expose
        private Object japaneseLevel;
        @SerializedName("scoreNumber")
        @Expose
        private Integer scoreNumber;
        @SerializedName("loginType")
        @Expose
        private Integer loginType;
        @SerializedName("avatarUrl")
        @Expose
        private Object avatarUrl;
        @SerializedName("facebookAddress")
        @Expose
        private Object facebookAddress;
        @SerializedName("educationLevel")
        @Expose
        private Object educationLevel;
        @SerializedName("speciality")
        @Expose
        private Object speciality;
        @SerializedName("visaType")
        @Expose
        private Object visaType;
        @SerializedName("interestField")
        @Expose
        private Object interestField;
        @SerializedName("webUserYn")
        @Expose
        private String webUserYn;
        @SerializedName("globalId")
        @Expose
        private Object globalId;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("verifiedPhoneYn")
        @Expose
        private String verifiedPhoneYn;
        @SerializedName("isOnline")
        @Expose
        private Object isOnline;
        @SerializedName("lastOnlineTime")
        @Expose
        private Object lastOnlineTime;
        @SerializedName("role")
        @Expose
        private Integer role;
        @SerializedName("countryId")
        @Expose
        private Integer countryId;
        @SerializedName("serverToken")
        @Expose
        private String serverToken;
        @SerializedName("avatarData")
        @Expose
        private Object avatarData;
        @SerializedName("coverUrl")
        @Expose
        private String coverUrl;
        @SerializedName("userRole")
        @Expose
        private UserRole userRole;

        public Object getDelYn() {
            return delYn;
        }

        public void setDelYn(Object delYn) {
            this.delYn = delYn;
        }

        public Object getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(Object createdTime) {
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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Object getPassword() {
            return password;
        }

        public void setPassword(Object password) {
            this.password = password;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public Object getSocialPassword() {
            return socialPassword;
        }

        public void setSocialPassword(Object socialPassword) {
            this.socialPassword = socialPassword;
        }

        public Object getBirthday() {
            return birthday;
        }

        public void setBirthday(Object birthday) {
            this.birthday = birthday;
        }

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCellPhone() {
            return cellPhone;
        }

        public void setCellPhone(String cellPhone) {
            this.cellPhone = cellPhone;
        }

        public Object getJapaneseLevel() {
            return japaneseLevel;
        }

        public void setJapaneseLevel(Object japaneseLevel) {
            this.japaneseLevel = japaneseLevel;
        }

        public Integer getScoreNumber() {
            return scoreNumber;
        }

        public void setScoreNumber(Integer scoreNumber) {
            this.scoreNumber = scoreNumber;
        }

        public Integer getLoginType() {
            return loginType;
        }

        public void setLoginType(Integer loginType) {
            this.loginType = loginType;
        }

        public Object getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(Object avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public Object getFacebookAddress() {
            return facebookAddress;
        }

        public void setFacebookAddress(Object facebookAddress) {
            this.facebookAddress = facebookAddress;
        }

        public Object getEducationLevel() {
            return educationLevel;
        }

        public void setEducationLevel(Object educationLevel) {
            this.educationLevel = educationLevel;
        }

        public Object getSpeciality() {
            return speciality;
        }

        public void setSpeciality(Object speciality) {
            this.speciality = speciality;
        }

        public Object getVisaType() {
            return visaType;
        }

        public void setVisaType(Object visaType) {
            this.visaType = visaType;
        }

        public Object getInterestField() {
            return interestField;
        }

        public void setInterestField(Object interestField) {
            this.interestField = interestField;
        }

        public String getWebUserYn() {
            return webUserYn;
        }

        public void setWebUserYn(String webUserYn) {
            this.webUserYn = webUserYn;
        }

        public Object getGlobalId() {
            return globalId;
        }

        public void setGlobalId(Object globalId) {
            this.globalId = globalId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getVerifiedPhoneYn() {
            return verifiedPhoneYn;
        }

        public void setVerifiedPhoneYn(String verifiedPhoneYn) {
            this.verifiedPhoneYn = verifiedPhoneYn;
        }

        public Object getIsOnline() {
            return isOnline;
        }

        public void setIsOnline(Object isOnline) {
            this.isOnline = isOnline;
        }

        public Object getLastOnlineTime() {
            return lastOnlineTime;
        }

        public void setLastOnlineTime(Object lastOnlineTime) {
            this.lastOnlineTime = lastOnlineTime;
        }

        public Integer getRole() {
            return role;
        }

        public void setRole(Integer role) {
            this.role = role;
        }

        public Integer getCountryId() {
            return countryId;
        }

        public void setCountryId(Integer countryId) {
            this.countryId = countryId;
        }

        public String getServerToken() {
            return serverToken;
        }

        public void setServerToken(String serverToken) {
            this.serverToken = serverToken;
        }

        public Object getAvatarData() {
            return avatarData;
        }

        public void setAvatarData(Object avatarData) {
            this.avatarData = avatarData;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public UserRole getUserRole() {
            return userRole;
        }

        public void setUserRole(UserRole userRole) {
            this.userRole = userRole;
        }

    }

    public class UserRole {
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
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("function")
        @Expose
        private Object function;

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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getFunction() {
            return function;
        }

        public void setFunction(Object function) {
            this.function = function;
        }

    }

}





package com.example.jpnetmvp.model;

import io.realm.RealmObject;

public class UserModel extends RealmObject {
    private String userName;
    private String email;
    private String phone;
    private String password;
    private int loginType;

    public UserModel() {
    }

    public UserModel(String userName, String email, String phone, String password, int loginType) {
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.loginType = loginType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }
}

package com.example.jpnetmvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListNewsModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("body")
    @Expose
    private List<NewModel> body = null;
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

    public List<NewModel> getBody() {
        return body;
    }

    public void setBody(List<NewModel> body) {
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

package com.example.jpnetmvp.model;

public class RequestHomeModel {
    private String serverToken;
    private int pageNumber;
    private int pageSize;

    public RequestHomeModel(String serverToken, int pageNumber, int pageSize) {
        this.serverToken = serverToken;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public String getServerToken() {
        return serverToken;
    }

    public void setServerToken(String serverToken) {
        this.serverToken = serverToken;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

package com.example.mvvm_architechture.base.models;

public class ErrorModel {
    public ErrorModel() { }

    public Boolean hasError() {
        return is;
    }

    public ErrorModel setIs(Boolean is) {
        this.is = is;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ErrorModel setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    Boolean is = false;
    String msg = "خطایی زخ داده است";
}

package com.example.mvvm_architechture.views.transaction;

public class TransactionUIModel {
    private Double amount = 0.0;
    private Integer status = -1;
    private Integer tranId = -1;
    private int type = -1;
    private Integer unreadChatCount = -1;
    private Long updateTime = -1L;
    private String firstName = "";
    private String lastName = "";
    private Integer userId = -1;
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getTranId() {
        return tranId;
    }
    public void setTranId(Integer tranId) {
        this.tranId = tranId;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public Integer getUnreadChatCount() {
        return unreadChatCount;
    }
    public void setUnreadChatCount(Integer unreadChatCount) {
        this.unreadChatCount = unreadChatCount;
    }
    public Long getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }}

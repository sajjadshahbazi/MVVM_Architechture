package com.example.mvvm_architechture.domain.servermodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionServerModel {
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("tran_id")
    @Expose
    private Integer tranId;
    @SerializedName("type")
    @Expose
    private int type;
    @SerializedName("unread_chat_count")
    @Expose
    private Integer unreadChatCount;
    @SerializedName("update_time")
    @Expose
    private Integer updateTime;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("user_id")
    @Expose
    private Integer userId;

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

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
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
    }
}

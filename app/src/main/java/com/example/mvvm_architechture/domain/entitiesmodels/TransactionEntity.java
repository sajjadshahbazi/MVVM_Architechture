package com.example.mvvm_architechture.domain.entitiesmodels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import static com.example.mvvm_architechture.utils.ConstantsApplication.TRANSACTION_DATA_BASE_NAME;

@Entity(tableName = TRANSACTION_DATA_BASE_NAME)
public class TransactionEntity {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "amount")
    private Double amount;
    @ColumnInfo(name = "status")
    private Integer status;
    @ColumnInfo(name = "tran_id")
    private Integer tranId;
    @ColumnInfo(name = "type")
    private int type;
    @ColumnInfo(name = "unread_chat_count")
    private Integer unreadChatCount;
    @ColumnInfo(name = "update_time")
    private Long updateTime;
    @ColumnInfo(name = "first_name")
    private String firstName;
    @ColumnInfo(name = "last_name")
    private String lastName;
    @ColumnInfo(name = "user_id")
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
    }
}

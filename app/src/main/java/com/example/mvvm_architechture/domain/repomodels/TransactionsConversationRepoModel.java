package com.example.mvvm_architechture.domain.repomodels;

import com.example.mvvm_architechture.domain.servermodels.TransactionServerModel;
import java.util.List;

public class TransactionsConversationRepoModel {
    private Double balance;
    private Integer lastGetTime;
    private Integer responseCode;
    private String responseMessage;
    private String responseValue;
    private List<TransactionServerModel> transactions = null;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getLastGetTime() {
        return lastGetTime;
    }

    public void setLastGetTime(Integer lastGetTime) {
        this.lastGetTime = lastGetTime;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseValue() {
        return responseValue;
    }

    public void setResponseValue(String responseValue) {
        this.responseValue = responseValue;
    }

    public List<TransactionServerModel> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionServerModel> transactions) {
        this.transactions = transactions;
    }
}

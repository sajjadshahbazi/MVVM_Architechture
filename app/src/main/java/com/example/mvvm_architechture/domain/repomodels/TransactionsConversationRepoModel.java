package com.example.mvvm_architechture.domain.repomodels;

import java.util.List;

public class TransactionsConversationRepoModel {
    private Double balance;
    private Long lastGetTime;
    private String responseMessage;
    private String responseValue;
    private List<TransactionRepoModel> transactions = null;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getLastGetTime() {
        return lastGetTime;
    }

    public void setLastGetTime(Long lastGetTime) {
        this.lastGetTime = lastGetTime;
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

    public List<TransactionRepoModel> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionRepoModel> transactions) {
        this.transactions = transactions;
    }
}

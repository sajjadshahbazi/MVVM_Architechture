package com.example.mvvm_architechture.domain.servermodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TransactionsConversationServerModel {
        @SerializedName("balance")
        @Expose
        private Double balance = 0.0;
        @SerializedName("last_get_time")
        @Expose
        private Integer lastGetTime=-1;
        @SerializedName("response_code")
        @Expose
        private Integer responseCode=-1;
        @SerializedName("response_message")
        @Expose
        private String responseMessage="";
        @SerializedName("response_value")
        @Expose
        private String responseValue="";
        @SerializedName("transactions")
        @Expose
        private List<TransactionServerModel> transactions = new ArrayList();

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

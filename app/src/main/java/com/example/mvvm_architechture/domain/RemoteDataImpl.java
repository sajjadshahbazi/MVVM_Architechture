package com.example.mvvm_architechture.domain;

import com.example.mvvm_architechture.domain.servermodels.LastTime;
import com.example.mvvm_architechture.domain.servermodels.TransactionServerModel;
import com.example.mvvm_architechture.domain.servermodels.TransactionsConversationServerModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Single;

public class RemoteDataImpl implements RemoteData {
    @Inject
    ApiServices apiServices;

    @Inject
    RemoteDataImpl(){}

    @Override
    public Single<TransactionsConversationServerModel> getRemoteTransactionsConversation(String lastTime) {
        TransactionsConversationServerModel fefef = new TransactionsConversationServerModel(); // TODO should delete from line 24 to 45 while stabled server
        fefef.setBalance(2673852.0);
        fefef.setLastGetTime(20200303084601L);
        fefef.setResponseCode(2020);
        fefef.setResponseMessage("عملیات با موفقیت انجام شد.");
        fefef.setResponseValue("");
        List<TransactionServerModel> list = new ArrayList<>();
        for (int i = 0 ; i<24 ; i++) {
            TransactionServerModel dfdfdf = new TransactionServerModel();
            dfdfdf.setAmount(5897004.0);
            dfdfdf.setFirstName("مژگان");
            dfdfdf.setLastName("میکائیلیان");
            dfdfdf.setStatus(1);
            dfdfdf.setType(2);
            dfdfdf.setTranId(i+564);
            dfdfdf.setUnreadChatCount(5);
            dfdfdf.setUpdateTime(20200229153236L);
            dfdfdf.setUserId(i+2020);
            list.add(dfdfdf);
        }
        fefef.setTransactions(list);
        return Single.just(fefef).delay(2L, TimeUnit.SECONDS);
//        return apiServices.getTransactionsConversationServerModel(new LastTime(lastTime)); // TODO should uncomment line while stabled server
    }
}

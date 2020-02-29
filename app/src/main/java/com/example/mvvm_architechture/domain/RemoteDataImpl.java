package com.example.mvvm_architechture.domain;

import com.example.mvvm_architechture.domain.servermodels.LastTime;
import com.example.mvvm_architechture.domain.servermodels.TransactionsConversationServerModel;
import javax.inject.Inject;

import io.reactivex.Single;

public class RemoteDataImpl implements RemoteData {
    @Inject
    ApiServices apiServices;

    @Inject
    RemoteDataImpl(){}

    @Override
    public Single<TransactionsConversationServerModel> getRemoteTransactionsConversation(String lastTime) {
        return apiServices.getTransactionsConversationServerModel(new LastTime(lastTime));
    }
}

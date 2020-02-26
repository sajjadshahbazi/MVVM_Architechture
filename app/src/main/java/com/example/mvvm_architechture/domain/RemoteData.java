package com.example.mvvm_architechture.domain;

import com.example.mvvm_architechture.domain.servermodels.TransactionsConversationServerModel;

import io.reactivex.Single;

public interface RemoteData {
    Single<TransactionsConversationServerModel> getRemoteTransactionsConversation(String lastTime);
}

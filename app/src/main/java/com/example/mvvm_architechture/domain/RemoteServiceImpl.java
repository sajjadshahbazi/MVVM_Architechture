package com.example.mvvm_architechture.domain;

import com.example.mvvm_architechture.domain.servermodels.TransactionsConversationServerModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class RemoteServiceImpl implements RemoteService {
    @Inject
    RemoteServiceImpl(){}

    @Override
    public Single<List<TransactionsConversationServerModel>> getTransactionsConversationServerModel() {
        return null;
    }
}

package com.example.mvvm_architechture.domain;

import com.example.mvvm_architechture.domain.repomodels.TransactionsConversationRepoModel;
import com.example.mvvm_architechture.domain.servermodels.TransactionsConversationServerModel;
import com.example.mvvm_architechture.utils.Mapper;
import javax.inject.Inject;
import io.reactivex.Single;

public class RepositoryImpl implements Repository {
    @Inject
    RemoteData remoteData;
    @Inject
    LocalData localService;
    @Inject
    Mapper<TransactionsConversationServerModel, TransactionsConversationRepoModel> transactionsConversationServerRepoMapper;

    @Inject
    RepositoryImpl() {}

    @Override
    public Single<TransactionsConversationRepoModel> getTransactionsConversation(String lastTime) {
//        return remoteData.getRemoteTransactionsConversation(lastTime).map(new FunTransactionsConversationRepoModel())
    }
}

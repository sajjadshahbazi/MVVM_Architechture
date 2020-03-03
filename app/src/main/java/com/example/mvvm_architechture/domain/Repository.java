package com.example.mvvm_architechture.domain;


import com.example.mvvm_architechture.domain.repomodels.TransactionsConversationRepoModel;
import io.reactivex.Completable;
import io.reactivex.Single;

public interface Repository {
    Single<TransactionsConversationRepoModel> getTransactionsConversation(String lastTime);
    Completable insertToDataBase(TransactionsConversationRepoModel transactions);
    Completable clearDatabase();
    Single<TransactionsConversationRepoModel> getTransactions();
}

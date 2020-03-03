package com.example.mvvm_architechture.domain;

import com.example.mvvm_architechture.domain.entitiesmodels.TransactionEntity;
import com.example.mvvm_architechture.domain.local.PreferencesHelper;
import com.example.mvvm_architechture.domain.repomodels.TransactionsConversationRepoModel;
import com.example.mvvm_architechture.domain.servermodels.TransactionsConversationServerModel;
import com.example.mvvm_architechture.utils.BiMapper;
import com.example.mvvm_architechture.utils.Mapper;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class RepositoryImpl implements Repository {
    @Inject
    RemoteData remoteData;
    @Inject
    LocalData localService;
    @Inject
    Mapper<TransactionsConversationServerModel, TransactionsConversationRepoModel> transactionsConversationServerRepoMapper;
    @Inject
    PreferencesHelper preferencesHelper;
    @Inject
    BiMapper<TransactionsConversationRepoModel, List<TransactionEntity>> transactionsConversationRepoEntityMapper;
    @Inject
    RepositoryImpl() {}

    @Override
    public Single<TransactionsConversationRepoModel> getTransactionsConversation(String lastTime) {
        return remoteData.getRemoteTransactionsConversation(lastTime).map(new Function<TransactionsConversationServerModel, TransactionsConversationRepoModel>() {
            @Override
            public TransactionsConversationRepoModel apply(TransactionsConversationServerModel transactionsConversationServerModel) {
                return transactionsConversationServerRepoMapper.map(transactionsConversationServerModel);
            }
        });
    }

    @Override
    public Completable insertToDataBase(TransactionsConversationRepoModel transactions) {
        preferencesHelper.insertBalance(transactions.getBalance());
        preferencesHelper.insertLastUpdate(transactions.getLastGetTime());
        return localService.databaseProvider().transactionDao().insetTransactions(
                transactionsConversationRepoEntityMapper.mapTo(transactions)
        );
    }

    @Override
    public Completable clearDatabase() {
        return localService.databaseProvider().transactionDao().clearDb();
    }

    @Override
    public Single<TransactionsConversationRepoModel> getTransactions() {
        return localService.databaseProvider().transactionDao().getTransactions().map(new Function<List<TransactionEntity>, TransactionsConversationRepoModel>() {
            @Override
            public TransactionsConversationRepoModel apply(List<TransactionEntity> transactionEntities) throws Exception {
                if (transactionEntities != null && transactionEntities.size()>0){
                    return transactionsConversationRepoEntityMapper.mapBack(transactionEntities);
                }else {
                    return new TransactionsConversationRepoModel();
                }

            }
        });
    }

}

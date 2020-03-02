package com.example.mvvm_architechture.domain.transaction;

import com.example.mvvm_architechture.domain.entitiesmodels.TransactionEntity;
import com.example.mvvm_architechture.domain.mapper.TransactionRepoEntityMapper;
import com.example.mvvm_architechture.domain.repomodels.TransactionRepoModel;
import com.example.mvvm_architechture.domain.repomodels.TransactionsConversationRepoModel;
import com.example.mvvm_architechture.domain.servermodels.TransactionServerModel;
import com.example.mvvm_architechture.domain.servermodels.TransactionsConversationServerModel;
import com.example.mvvm_architechture.utils.BiMapper;
import com.example.mvvm_architechture.utils.Mapper;

import java.util.List;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class TransactionDomainModule {
    @Binds
    abstract Mapper<TransactionsConversationServerModel, TransactionsConversationRepoModel> bindTransactionsConversationRepoUiMapper(
            TransactionsConversationServerRepoMapper mapper
    );

    @Binds
    abstract Mapper<List<TransactionServerModel>, List<TransactionRepoModel>> bindTransactionRepoUiMapper(
            TransactionServerRepoMapper mapper
    );

    @Binds
    abstract BiMapper<TransactionsConversationRepoModel, List<TransactionEntity>> bindTransactionRepoEntityMapper(
            TransactionRepoEntityMapper mapper
    );
}

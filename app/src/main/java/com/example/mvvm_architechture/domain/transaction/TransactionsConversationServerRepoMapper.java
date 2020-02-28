package com.example.mvvm_architechture.domain.transaction;

import com.example.mvvm_architechture.domain.repomodels.TransactionRepoModel;
import com.example.mvvm_architechture.domain.repomodels.TransactionsConversationRepoModel;
import com.example.mvvm_architechture.domain.servermodels.TransactionServerModel;
import com.example.mvvm_architechture.domain.servermodels.TransactionsConversationServerModel;
import com.example.mvvm_architechture.utils.Mapper;
import java.util.List;
import javax.inject.Inject;


public class TransactionsConversationServerRepoMapper implements Mapper<
        TransactionsConversationServerModel,
        TransactionsConversationRepoModel
        > {
    Mapper<List<TransactionServerModel>, List<TransactionRepoModel>> transactionMapper;


    @Inject
    TransactionsConversationServerRepoMapper(
            Mapper<List<TransactionServerModel>, List<TransactionRepoModel>> transactionMapper
    ){
        this.transactionMapper = transactionMapper;
    }

    @Override
    public TransactionsConversationRepoModel map(TransactionsConversationServerModel input) {
        TransactionsConversationRepoModel model = new TransactionsConversationRepoModel();
        model.setBalance(input.getBalance());
        model.setLastGetTime(input.getLastGetTime());
        model.setResponseMessage(input.getResponseMessage());
        model.setResponseValue(input.getResponseValue());
        model.setTransactions(this.transactionMapper.map(input.getTransactions()));
        return model;
    }
}

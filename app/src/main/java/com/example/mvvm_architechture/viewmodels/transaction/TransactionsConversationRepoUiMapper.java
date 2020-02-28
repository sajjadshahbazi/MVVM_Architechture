package com.example.mvvm_architechture.viewmodels.transaction;

import com.example.mvvm_architechture.domain.repomodels.TransactionRepoModel;
import com.example.mvvm_architechture.domain.repomodels.TransactionsConversationRepoModel;
import com.example.mvvm_architechture.utils.Mapper;
import com.example.mvvm_architechture.views.transaction.TransactionUIModel;
import com.example.mvvm_architechture.views.transaction.TransactionsConversationUIModel;
import java.util.List;
import javax.inject.Inject;


public class TransactionsConversationRepoUiMapper implements Mapper<
        TransactionsConversationRepoModel,
        TransactionsConversationUIModel
        > {
    Mapper<List<TransactionRepoModel>, List<TransactionUIModel>> transactionMapper;

    @Inject
    TransactionsConversationRepoUiMapper(
            Mapper<List<TransactionRepoModel>,
                    List<TransactionUIModel>> transactionMapper
    ){
        this.transactionMapper = transactionMapper;
    }

    @Override
    public TransactionsConversationUIModel map(TransactionsConversationRepoModel input) {
        TransactionsConversationUIModel model = new TransactionsConversationUIModel();
        model.setBalance(input.getBalance());
        model.setLastGetTime(input.getLastGetTime());
        model.setResponseMessage(input.getResponseMessage());
        model.setResponseValue(input.getResponseValue());
        model.setTransactions(this.transactionMapper.map(input.getTransactions()));
        return model;
    }
}

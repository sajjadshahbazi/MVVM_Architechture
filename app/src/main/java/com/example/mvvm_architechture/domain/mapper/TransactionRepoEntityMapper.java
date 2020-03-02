package com.example.mvvm_architechture.domain.mapper;

import com.example.mvvm_architechture.domain.entitiesmodels.TransactionEntity;
import com.example.mvvm_architechture.domain.local.PreferencesHelper;
import com.example.mvvm_architechture.domain.repomodels.TransactionRepoModel;
import com.example.mvvm_architechture.domain.repomodels.TransactionsConversationRepoModel;
import com.example.mvvm_architechture.utils.BiMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


public class TransactionRepoEntityMapper implements BiMapper<TransactionsConversationRepoModel, List<TransactionEntity>> {
    @Inject
    public TransactionRepoEntityMapper() {}
    @Inject
    PreferencesHelper preferencesHelper;

    @Override
    public List<TransactionEntity> mapTo(TransactionsConversationRepoModel input) {
        List<TransactionEntity> list = new ArrayList();
        for (TransactionRepoModel trans : input.getTransactions()){
            TransactionEntity transactionEntity = new TransactionEntity();
            transactionEntity.setAmount(trans.getAmount());
            transactionEntity.setFirstName(trans.getFirstName());
            transactionEntity.setLastName(trans.getLastName());
            transactionEntity.setStatus(trans.getStatus());
            transactionEntity.setTranId(trans.getTranId());
            transactionEntity.setType(trans.getType());
            transactionEntity.setUnreadChatCount(trans.getUnreadChatCount());
            transactionEntity.setUpdateTime(trans.getUpdateTime());
            transactionEntity.setUserId(trans.getUserId());
            list.add(transactionEntity);
        }
        return list;
    }

    @Override
    public TransactionsConversationRepoModel mapBack(List<TransactionEntity> input) {
        TransactionsConversationRepoModel transactionsConversationRepoModel = new TransactionsConversationRepoModel();
        for (TransactionEntity trans : input){
            TransactionRepoModel transactionEntity = new TransactionRepoModel();
            transactionEntity.setAmount(trans.getAmount());
            transactionEntity.setFirstName(trans.getFirstName());
            transactionEntity.setLastName(trans.getLastName());
            transactionEntity.setStatus(trans.getStatus());
            transactionEntity.setTranId(trans.getTranId());
            transactionEntity.setType(trans.getType());
            transactionEntity.setUnreadChatCount(trans.getUnreadChatCount());
            transactionEntity.setUpdateTime(trans.getUpdateTime());
            transactionEntity.setUserId(trans.getUserId());
            transactionsConversationRepoModel.getTransactions().add(transactionEntity);
            transactionsConversationRepoModel.setBalance(preferencesHelper.getBalance());
            transactionsConversationRepoModel.setLastGetTime(preferencesHelper.getLastUpdate());
        }
        return transactionsConversationRepoModel;
    }
}

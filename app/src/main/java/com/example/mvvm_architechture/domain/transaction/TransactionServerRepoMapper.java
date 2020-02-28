package com.example.mvvm_architechture.domain.transaction;

import com.example.mvvm_architechture.domain.repomodels.TransactionRepoModel;
import com.example.mvvm_architechture.domain.servermodels.TransactionServerModel;
import com.example.mvvm_architechture.utils.Mapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class TransactionServerRepoMapper implements Mapper<List<TransactionServerModel>, List<TransactionRepoModel>> {

    @Inject
    TransactionServerRepoMapper(){}

    @Override
    public List<TransactionRepoModel> map(List<TransactionServerModel> input) {
        List<TransactionRepoModel> list = new ArrayList();
        for (TransactionServerModel trans : input){
            TransactionRepoModel transactionUIModel = new TransactionRepoModel();
            transactionUIModel.setAmount(trans.getAmount());
            transactionUIModel.setFirstName(trans.getFirstName());
            transactionUIModel.setLastName(trans.getLastName());
            transactionUIModel.setStatus(trans.getStatus());
            transactionUIModel.setTranId(trans.getTranId());
            transactionUIModel.setType(trans.getType());
            transactionUIModel.setUnreadChatCount(trans.getUnreadChatCount());
            transactionUIModel.setUpdateTime(trans.getUpdateTime());
            transactionUIModel.setUserId(trans.getUserId());
            list.add(transactionUIModel);
        }
        return list;
    }
}
package com.example.mvvm_architechture.viewmodels.transaction;

import com.example.mvvm_architechture.domain.repomodels.TransactionRepoModel;
import com.example.mvvm_architechture.utils.Mapper;
import com.example.mvvm_architechture.views.transaction.TransactionUIModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


public class TransactionRepoUiMapper implements Mapper<List<TransactionRepoModel>, List<TransactionUIModel>> {

    @Inject
    TransactionRepoUiMapper(){}

    @Override
    public List<TransactionUIModel> map(List<TransactionRepoModel> input) {
        List<TransactionUIModel> list = new ArrayList();
        for (TransactionRepoModel trans : input){
            TransactionUIModel transactionUIModel = new TransactionUIModel();
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

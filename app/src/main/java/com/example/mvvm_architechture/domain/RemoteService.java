package com.example.mvvm_architechture.domain;

import com.example.mvvm_architechture.domain.servermodels.TransactionsConversationServerModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.POST;

public interface RemoteService {

    @POST("user/home")
    Single<List<TransactionsConversationServerModel>> getTransactionsConversationServerModel();
}

package com.example.mvvm_architechture.domain;

import com.example.mvvm_architechture.domain.servermodels.LastTime;
import com.example.mvvm_architechture.domain.servermodels.TransactionsConversationServerModel;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServices {
    @POST("user/home")
    Single<TransactionsConversationServerModel> getTransactionsConversationServerModel(@Body LastTime lastTime);
}

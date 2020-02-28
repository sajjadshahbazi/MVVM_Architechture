package com.example.mvvm_architechture.domain;

import com.example.mvvm_architechture.domain.servermodels.TransactionsConversationServerModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServices {

    @FormUrlEncoded
    @POST("user/home")
    Single<TransactionsConversationServerModel> getTransactionsConversationServerModel(@Field("last_get_time") String lastTime);
}

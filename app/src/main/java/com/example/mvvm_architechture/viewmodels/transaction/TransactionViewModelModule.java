package com.example.mvvm_architechture.viewmodels.transaction;


import androidx.lifecycle.ViewModel;

import com.example.mvvm_architechture.di.utils.ViewModelKey;
import com.example.mvvm_architechture.domain.repomodels.TransactionRepoModel;
import com.example.mvvm_architechture.domain.repomodels.TransactionsConversationRepoModel;
import com.example.mvvm_architechture.utils.Mapper;
import com.example.mvvm_architechture.views.transaction.TransactionUIModel;
import com.example.mvvm_architechture.views.transaction.TransactionsConversationUIModel;

import java.util.List;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import kotlin.jvm.JvmSuppressWildcards;


@Module
public abstract class TransactionViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TransactionViewModel.class)
    abstract ViewModel bindLTransactionViewModel(TransactionViewModel listViewModel);

    @Binds
    abstract Mapper<TransactionsConversationRepoModel, TransactionsConversationUIModel> bindTransactionsConversationRepoUiMapper(
            TransactionsConversationRepoUiMapper mapper
    );

    @Binds
    abstract Mapper<List <TransactionRepoModel>, List<TransactionUIModel>> bindTransactionRepoUiMapper(
            TransactionRepoUiMapper mapper
    );
}

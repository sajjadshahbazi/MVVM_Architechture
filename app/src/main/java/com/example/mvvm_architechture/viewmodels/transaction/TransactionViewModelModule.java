package com.example.mvvm_architechture.viewmodels.transaction;


import androidx.lifecycle.ViewModel;

import com.example.mvvm_architechture.di.utils.ViewModelKey;
import com.example.mvvm_architechture.viewmodels.transaction.TransactionViewModelImpl;

import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Module
public abstract class TransactionViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TransactionViewModelImpl.class)
    abstract ViewModel bindLTransactionViewModel(TransactionViewModelImpl listViewModel);
}

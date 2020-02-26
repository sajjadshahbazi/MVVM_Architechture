package com.example.mvvm_architechture.di;

import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm_architechture.viewmodels.base.ViewModelFactory;
import com.example.mvvm_architechture.viewmodels.transaction.TransactionViewModelModule;

import dagger.Binds;
import dagger.Module;

@Module(includes = {
        TransactionViewModelModule.class
})
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}

package com.example.mvvm_architechture.base;

import com.example.mvvm_architechture.domain.LocalData;
import com.example.mvvm_architechture.domain.LocalDataImpl;
import com.example.mvvm_architechture.domain.RemoteData;
import com.example.mvvm_architechture.domain.RemoteDataImpl;
import com.example.mvvm_architechture.domain.Repository;
import com.example.mvvm_architechture.domain.RepositoryImpl;

import dagger.Binds;
import dagger.Module;

@Module
abstract class AppModule {
    @Binds
    abstract Repository bindRepository(RepositoryImpl repository);
    @Binds
    abstract LocalData bindLocalService(LocalDataImpl localService);
    @Binds
    abstract RemoteData bindRemoteData(RemoteDataImpl remoteService);
}

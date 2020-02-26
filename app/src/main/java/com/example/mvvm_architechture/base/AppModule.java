package com.example.mvvm_architechture.base;

import com.example.mvvm_architechture.domain.LocalService;
import com.example.mvvm_architechture.domain.LocalServiceImpl;
import com.example.mvvm_architechture.domain.RemoteService;
import com.example.mvvm_architechture.domain.RemoteServiceImpl;
import com.example.mvvm_architechture.domain.Repository;
import com.example.mvvm_architechture.domain.RepositoryImpl;

import dagger.Binds;
import dagger.Module;

@Module
abstract class AppModule {
    @Binds
    abstract Repository bindRepository(RepositoryImpl repository);
    @Binds
    abstract LocalService bindLocalService(LocalServiceImpl localService);
    @Binds
    abstract RemoteService bindRemoteService(RemoteServiceImpl remoteService);
}

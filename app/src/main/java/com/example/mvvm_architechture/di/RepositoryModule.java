package com.example.mvvm_architechture.di;

import com.example.mvvm_architechture.domain.RoomHelper;
import com.example.mvvm_architechture.domain.RoomHelperImpl;
import com.example.mvvm_architechture.domain.RemoteData;
import com.example.mvvm_architechture.domain.RemoteDataImpl;
import com.example.mvvm_architechture.domain.Repository;
import com.example.mvvm_architechture.domain.RepositoryImpl;
import com.example.mvvm_architechture.domain.local.PreferencesHelper;
import com.example.mvvm_architechture.domain.local.PreferencesHelperImpl;
import com.example.mvvm_architechture.domain.transaction.TransactionDomainModule;
import dagger.Binds;
import dagger.Module;

@Module(includes = {
        TransactionDomainModule.class
})
abstract class RepositoryModule {
    @Binds
    abstract Repository bindRepository(RepositoryImpl repository);
    @Binds
    abstract RoomHelper bindLocalService(RoomHelperImpl localService);
    @Binds
    abstract RemoteData bindRemoteData(RemoteDataImpl remoteService);
    @Binds
    abstract PreferencesHelper bindPreferencesHelper(PreferencesHelperImpl preferencesHelper);
}

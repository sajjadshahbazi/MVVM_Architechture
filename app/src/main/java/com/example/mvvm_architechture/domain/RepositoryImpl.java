package com.example.mvvm_architechture.domain;

import javax.inject.Inject;

public class RepositoryImpl implements Repository {
    @Inject
    RepositoryImpl(
            RemoteService remoteService,
            LocalService localService
    ) {

    }
}

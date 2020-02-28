package com.example.mvvm_architechture.di;

import dagger.Module;

@Module( includes = {
        NetworkModule.class,
        RepositoryModule.class,
})
public class ApplicationModule {}

package com.example.mvvm_architechture.di;


import com.example.mvvm_architechture.views.TransactionActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector()
    abstract TransactionActivity bindMainActivity();
}

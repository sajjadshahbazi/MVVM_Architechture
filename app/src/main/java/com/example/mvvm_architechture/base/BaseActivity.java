package com.example.mvvm_architechture.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm_architechture.viewmodels.transaction.TransactionViewModelImpl;
import com.example.mvvm_architechture.viewmodels.base.ViewModelFactory;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity <
        V extends ViewModel
        > extends DaggerAppCompatActivity {

    private ViewModel viewModel;

    @Inject
    ViewModelFactory viewModelFactory;

    @LayoutRes
    protected abstract int layoutRes();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewModel(new ViewModelProvider(this, viewModelFactory).get(TransactionViewModelImpl.class));
        setContentView(layoutRes());
        ButterKnife.bind(this);
    }

    public abstract void getViewModel(ViewModel viewModelP);
}

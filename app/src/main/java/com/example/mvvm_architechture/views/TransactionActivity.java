package com.example.mvvm_architechture.views;


import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import com.example.mvvm_architechture.R;
import com.example.mvvm_architechture.base.BaseActivity;
import com.example.mvvm_architechture.viewmodels.transaction.TransactionViewModelImpl;

public class TransactionActivity extends BaseActivity<TransactionViewModelImpl> {

    private TransactionViewModelImpl viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void getViewModel(ViewModel viewModelP) {
       viewModel = (TransactionViewModelImpl) viewModelP;
    }


    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }
}

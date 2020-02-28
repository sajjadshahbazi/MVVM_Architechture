package com.example.mvvm_architechture.views.transaction;


import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.ViewModel;
import com.example.mvvm_architechture.R;
import com.example.mvvm_architechture.base.BaseActivity;
import com.example.mvvm_architechture.viewmodels.transaction.TransactionViewModel;


public class TransactionActivity extends BaseActivity<TransactionViewModel> {

    private TransactionViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        observableViewModel();
    }

    @Override
    public void getViewModel(ViewModel viewModelP) {
       viewModel = (TransactionViewModel) viewModelP;
    }


    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    private void observableViewModel() {
        viewModel.fetchTransactions("20200101000000").observe(this, transactionsConversation -> {
//            if(transactionsConversation != null) listView.setVisibility(View.VISIBLE);
            Log.d("Sajjad", transactionsConversation.getResponseMessage());
        });

        viewModel.getError().observe(this, isError -> {
            if (isError != null) if(isError) {
//                errorTextView.setVisibility(View.VISIBLE);
//                listView.setVisibility(View.GONE);
//                errorTextView.setText("An Error Occurred While Loading Data!");
            }else {
//                errorTextView.setVisibility(View.GONE);
//                errorTextView.setText(null);
            }
        });

        viewModel.getLoading().observe(this, isLoading -> {
            if (isLoading != null) {
//                loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if (isLoading) {
//                    errorTextView.setVisibility(View.GONE);
//                    listView.setVisibility(View.GONE);
                }
            }
        });
    }
}

package com.example.mvvm_architechture.views.transaction;


import android.os.Bundle;
import android.widget.ImageView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvm_architechture.R;
import com.example.mvvm_architechture.base.BaseActivity;
import com.example.mvvm_architechture.viewmodels.transaction.TransactionViewModel;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;


public class TransactionActivity extends BaseActivity<TransactionViewModel> {

    private TransactionViewModel viewModel;
    @BindView(R.id.transactionsList)
    RecyclerView transactionsList;
    @BindView(R.id.avatarImg)
    ImageView avatarImg;
    private TransactionAdapter mAdapter;

    @Override
    public Class<TransactionViewModel> getViewModel() {
        return TransactionViewModel.class;
    }

    @Override
    protected void onCreate(Bundle instance, TransactionViewModel viewModel) {
        this.viewModel = viewModel;
        observableViewModel();
        Glide.with(this).load("https://banner2.cleanpng.com/20171128/5d2/gold-soccer-ball-png-clip-art-image-5a1d466b159ac0.0656563615118680110885.jpg").apply(new RequestOptions().circleCrop()).into(avatarImg);
    }

    @Override
    protected int layoutRes() {
        return R.layout.transaction_conversation_activity;
    }

    private void observableViewModel() {
        viewModel.fetchTransactions("20200101000000").observe(this, transactionsConversation -> {
            mAdapter = new TransactionAdapter(transactionsConversation.getTransactions());
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            transactionsList.setLayoutManager(mLayoutManager);
            transactionsList.setItemAnimator(new DefaultItemAnimator());
            transactionsList.setAdapter(mAdapter);
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

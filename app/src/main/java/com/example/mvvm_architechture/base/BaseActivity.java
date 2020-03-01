package com.example.mvvm_architechture.base;

import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.mvvm_architechture.viewmodels.base.ViewModelFactory;
import javax.inject.Inject;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity <
        T extends ViewModel
        > extends DaggerAppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;


    @LayoutRes
    protected abstract int layoutRes();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModel viewModel = new ViewModelProvider(this, viewModelFactory).get(getViewModel());
        setContentView(layoutRes());
        ButterKnife.bind(this);
        onCreate(savedInstanceState, (T) viewModel);
    }

    public abstract Class<T> getViewModel();
    protected abstract void onCreate(Bundle instance, T viewModel);
}

package com.example.mvvm_architechture.viewmodels.transaction;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.mvvm_architechture.domain.Repository;
import com.example.mvvm_architechture.domain.repomodels.TransactionsConversationRepoModel;
import com.example.mvvm_architechture.utils.Mapper;
import com.example.mvvm_architechture.views.transaction.TransactionsConversationUIModel;
import javax.inject.Inject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class TransactionViewModel extends ViewModel {
    private Repository repoRepository;
    private CompositeDisposable disposable;

    private final MutableLiveData<TransactionsConversationUIModel> repos = new MutableLiveData<>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    Mapper<TransactionsConversationRepoModel, TransactionsConversationUIModel> transactionsConversationRepoUiMapper;

    @Inject
    public TransactionViewModel(Repository repoRepository) {
        this.repoRepository = repoRepository;
        disposable = new CompositeDisposable();
//        fetchRepos();
    }

//    public LiveData<TransactionsConversationUIModel> getTransactionsConversation() { return repos; }
    public LiveData<Boolean> getError() {
        return repoLoadError;
    }
    public LiveData<Boolean> getLoading() {
        return loading;
    }

    public MutableLiveData<TransactionsConversationUIModel> fetchTransactions(String lastTime) {
        loading.setValue(true);
        disposable.add(repoRepository.getTransactionsConversation(lastTime).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<TransactionsConversationRepoModel>() {
                    @Override
                    public void onSuccess(TransactionsConversationRepoModel value) {
                        repoLoadError.setValue(false);
                        repos.setValue(transactionsConversationRepoUiMapper.map(value));
                        loading.setValue(false);
                    }
                    @Override
                    public void onError(Throwable e) {
                        repoLoadError.setValue(true);
                        loading.setValue(false);
                    }
                }));
        return repos;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}

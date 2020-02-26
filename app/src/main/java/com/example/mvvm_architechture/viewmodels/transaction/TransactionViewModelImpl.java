package com.example.mvvm_architechture.viewmodels.transaction;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_architechture.domain.Repository;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


public class TransactionViewModelImpl extends ViewModel implements TransactionViewModel {
    private final Repository repoRepository;
    private CompositeDisposable disposable;

//    private final MutableLiveData<List<Repo>> repos = new MutableLiveData<>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public TransactionViewModelImpl(Repository repoRepository) {
        this.repoRepository = repoRepository;
        disposable = new CompositeDisposable();
//        fetchRepos();
    }

//    LiveData<List<Repo>> getRepos() {
//        return repos;
//    }

    LiveData<Boolean> getError() {
        return repoLoadError;
    }

    LiveData<Boolean> getLoading() {
        return loading;
    }

//    private void fetchRepos() {
//        loading.setValue(true);
//        disposable.add(repoRepository.getRepositories().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<Repo>>() {
//                    @Override
//                    public void onSuccess(List<Repo> value) {
//                        repoLoadError.setValue(false);
//                        repos.setValue(value);
//                        loading.setValue(false);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        repoLoadError.setValue(true);
//                        loading.setValue(false);
//                    }
//                }));
//    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}

package com.example.mvvm_architechture.viewmodels.transaction;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.mvvm_architechture.base.models.ErrorModel;
import com.example.mvvm_architechture.domain.Repository;
import com.example.mvvm_architechture.domain.repomodels.TransactionsConversationRepoModel;
import com.example.mvvm_architechture.utils.Mapper;
import com.example.mvvm_architechture.views.transaction.TransactionsConversationUIModel;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class TransactionViewModel extends ViewModel {
    private Repository repoRepository;
    private CompositeDisposable disposable;

    private final MutableLiveData<TransactionsConversationUIModel> repos = new MutableLiveData<>();
    private final MutableLiveData<ErrorModel> error = new MutableLiveData<ErrorModel>(new ErrorModel());
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    Mapper<TransactionsConversationRepoModel, TransactionsConversationUIModel> transactionsConversationRepoUiMapper;

    @Inject
    public TransactionViewModel(Repository repoRepository) {
        this.repoRepository = repoRepository;
        disposable = new CompositeDisposable();
    }

    public LiveData<ErrorModel> getError() {
        return error;
    }
    public LiveData<Boolean> getLoading() {
        return loading;
    }

    public MutableLiveData<TransactionsConversationUIModel> fetchTrans(String lastTime) {
        loading.setValue(true);
        disposable.add((Disposable) Observable.concat(
                repoRepository.getTransactions().toObservable(),
                repoRepository.getTransactionsConversation(lastTime).toObservable().compose(updateDb())
        ).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<TransactionsConversationRepoModel>() {

                            @Override
                            public void onNext(TransactionsConversationRepoModel value) {
                                error.setValue(new ErrorModel().setIs(false));
                                repos.setValue(transactionsConversationRepoUiMapper.map(value));
                                loading.setValue(false);
                            }

                            @Override
                            public void onError(Throwable e) {
                                if (e != null && e.getMessage() != null) {
                                    error.setValue(new ErrorModel().setIs(true).setMsg(e.getMessage()));
                                } else {
                                    error.setValue(new ErrorModel().setIs(true));
                                }
                                loading.setValue(false);
                            }

                            @Override
                            public void onComplete() { }
                        }));
        return repos;
    }

    ObservableTransformer updateDb() {
        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable upstream) {
                return upstream.switchMap(new Function<TransactionsConversationRepoModel, Observable<TransactionsConversationRepoModel>>() {
                    @Override
                    public Observable<TransactionsConversationRepoModel> apply(TransactionsConversationRepoModel repoModel) throws Exception {
                        return Observable.just(repoModel)
                                .startWith(repoRepository.insertToDataBase(repoModel).toObservable())
                                .startWith(repoRepository.clearDatabase().toObservable());
                    }
                });
            }
        };
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

package com.example.mvvm_architechture.domain.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.mvvm_architechture.domain.entitiesmodels.TransactionEntity;
import java.util.List;
import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insetTransactions(List<TransactionEntity> transactions);

    @Query("DELETE FROM `TRANSACTION`")
    Completable clearDb();

    @Query("SELECT * FROM `TRANSACTION`")
    Single<List<TransactionEntity>> getTransactions();
}

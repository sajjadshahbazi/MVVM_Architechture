package com.example.mvvm_architechture.domain.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.mvvm_architechture.domain.entitiesmodels.TransactionEntity;

@Database(entities = {TransactionEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TransactionDao transactionDao();
}

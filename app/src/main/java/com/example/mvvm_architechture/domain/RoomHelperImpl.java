package com.example.mvvm_architechture.domain;

import android.content.Context;

import androidx.room.Room;

import com.example.mvvm_architechture.domain.local.AppDatabase;
import javax.inject.Inject;
import static com.example.mvvm_architechture.utils.ConstantsApplication.TRANSACTION_DATA_BASE_NAME;

public class RoomHelperImpl implements RoomHelper {
    @Inject
    RoomHelperImpl(){}
    @Inject
    Context context;

    @Override
    public AppDatabase databaseProvider() {
        return Room.databaseBuilder(context, AppDatabase.class, TRANSACTION_DATA_BASE_NAME).build();
    }
}

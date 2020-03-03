package com.example.mvvm_architechture.domain;

import com.example.mvvm_architechture.domain.local.AppDatabase;

public interface RoomHelper {
    AppDatabase databaseProvider();
}

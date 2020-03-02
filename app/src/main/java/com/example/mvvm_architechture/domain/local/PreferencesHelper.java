package com.example.mvvm_architechture.domain.local;

public interface PreferencesHelper {
    void insertBalance(Double value);
    void insertLastUpdate(Long value);
    Double getBalance();
    Long getLastUpdate();
}

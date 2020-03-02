package com.example.mvvm_architechture.utils;

public enum  TransactionType {
    SendMoney(1),
    ReceiveMoney(2),
    CacheIn(3),
    CacheOut(4);

    private final int value;

    TransactionType(int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}

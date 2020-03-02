package com.example.mvvm_architechture.utils;

public interface BiMapper<T, V> {
    V mapTo(T input);
    T mapBack(V input);
}



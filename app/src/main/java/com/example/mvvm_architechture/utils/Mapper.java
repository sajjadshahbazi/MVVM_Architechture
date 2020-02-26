package com.example.mvvm_architechture.utils;

public interface Mapper<T, V> {
    V map(T input);
}

package com.example.demo;

public interface ComputingService<T> {

    T add(T a, T b);
    T minus(T a, T b);
    T times(T a, T b);
    T divide(T a, T b);
}

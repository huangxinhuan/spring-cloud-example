package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class ComputingServiceImpl implements ComputingService<Double> {
    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double minus(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double times(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double divide(Double a, Double b) {
        return a / b;
    }
}

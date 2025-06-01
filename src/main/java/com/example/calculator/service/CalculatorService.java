package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double add(double a, double b) { return a + b; }
    public double subtract(double a, double b) { return a - b; }
    public double multiply(double a, double b) { return a * b; }
    public double divide(double a, double b) { if (b == 0) throw new ArithmeticException("Division by zero"); return a / b; }
    public double power(double a, double b) { return Math.pow(a, b); }
    public double root(double a, double n) { return Math.pow(a, 1.0 / n); }
    public double log(double a, double base) { return Math.log(a) / Math.log(base); }
    public double ln(double a) { return Math.log(a); }
    public double exp(double a) { return Math.exp(a); }
    public long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative factorial");
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
    public double mod(double a, double b) { return a % b; }
    public double abs(double a) { return Math.abs(a); }
}
package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calc")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/add")
    public double add(@RequestParam double a, @RequestParam double b) { return calculatorService.add(a, b); }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double a, @RequestParam double b) { return calculatorService.subtract(a, b); }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double a, @RequestParam double b) { return calculatorService.multiply(a, b); }

    @GetMapping("/divide")
    public double divide(@RequestParam double a, @RequestParam double b) { return calculatorService.divide(a, b); }

    @GetMapping("/power")
    public double power(@RequestParam double a, @RequestParam double b) { return calculatorService.power(a, b); }

    @GetMapping("/root")
    public double root(@RequestParam double a, @RequestParam double n) { return calculatorService.root(a, n); }

    @GetMapping("/log")
    public double log(@RequestParam double a, @RequestParam double base) { return calculatorService.log(a, base); }

    @GetMapping("/ln")
    public double ln(@RequestParam double a) { return calculatorService.ln(a); }

    @GetMapping("/exp")
    public double exp(@RequestParam double a) { return calculatorService.exp(a); }

    @GetMapping("/factorial")
    public long factorial(@RequestParam int n) { return calculatorService.factorial(n); }

    @GetMapping("/mod")
    public double mod(@RequestParam double a, @RequestParam double b) { return calculatorService.mod(a, b); }

    @GetMapping("/abs")
    public double abs(@RequestParam double a) { return calculatorService.abs(a); }
}
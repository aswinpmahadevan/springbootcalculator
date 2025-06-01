package com.example.calculator.controller;

import com.example.calculator.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/measure")
public class MeasurementController {

    @Autowired
    private MeasurementService service;

    @GetMapping("/calculate")
    public Map<String, Object> calculate(
            @RequestParam String shape,
            @RequestParam String measureType,
            @RequestParam Map<String, String> allParams
    ) {
        Map<String, Double> params = new HashMap<>();
        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            if (!entry.getKey().equals("shape") && !entry.getKey().equals("measureType")) {
                try {
                    params.put(entry.getKey(), Double.parseDouble(entry.getValue()));
                } catch (Exception ignored) {}
            }
        }
        return service.calculateAndStore(shape, measureType, params);
    }
}
package com.example.calculator.service;

import com.example.calculator.model.MeasurementTransaction;
import com.example.calculator.repository.MeasurementTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementTransactionRepository repo;

    public Map<String, Object> calculateAndStore(String shape, String measureType, Map<String, Double> params) {
        double value = 0;
        switch (shape) {
            case "circle":
                double radius = params.getOrDefault("radius", 0.0);
                if ("area".equals(measureType)) value = Math.PI * radius * radius;
                else value = 2 * Math.PI * radius;
                break;
            case "square":
                double side = params.getOrDefault("side", 0.0);
                if ("area".equals(measureType)) value = side * side;
                else value = 4 * side;
                break;
            case "rectangle":
                double length = params.getOrDefault("length", 0.0);
                double width = params.getOrDefault("width", 0.0);
                if ("area".equals(measureType)) value = length * width;
                else value = 2 * (length + width);
                break;
            case "triangle":
                double a = params.getOrDefault("a", 0.0);
                double b = params.getOrDefault("b", 0.0);
                double c = params.getOrDefault("c", 0.0);
                if ("area".equals(measureType)) {
                    double s = (a + b + c) / 2;
                    value = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                } else value = a + b + c;
                break;
            case "cube":
                double cubeSide = params.getOrDefault("side", 0.0);
                if ("area".equals(measureType)) value = 6 * cubeSide * cubeSide;
                else value = 12 * cubeSide;
                break;
            case "cylinder":
                double cylRadius = params.getOrDefault("radius", 0.0);
                double height = params.getOrDefault("height", 0.0);
                if ("area".equals(measureType)) value = 2 * Math.PI * cylRadius * (cylRadius + height);
                else value = 2 * Math.PI * cylRadius;
                break;
        }

        MeasurementTransaction tx = new MeasurementTransaction();
        tx.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        tx.setShape(shape);
        tx.setMeasureType(measureType);
        tx.setParameters(params.toString());
        tx.setValue(value);
        tx.setTimestamp(LocalDateTime.now());
        repo.save(tx);

        Map<String, Object> result = new HashMap<>();
        result.put("shape", shape);
        result.put("measureType", measureType);
        result.put("value", value);
        return result;
    }
}
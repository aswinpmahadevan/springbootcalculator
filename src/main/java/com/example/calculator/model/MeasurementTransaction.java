package com.example.calculator.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MeasurementTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String shape;
    private String measureType;
    private String parameters;
    private double value;
    private LocalDateTime timestamp;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getShape() { return shape; }
    public void setShape(String shape) { this.shape = shape; }
    public String getMeasureType() { return measureType; }
    public void setMeasureType(String measureType) { this.measureType = measureType; }
    public String getParameters() { return parameters; }
    public void setParameters(String parameters) { this.parameters = parameters; }
    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
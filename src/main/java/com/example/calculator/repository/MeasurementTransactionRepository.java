package com.example.calculator.repository;

import com.example.calculator.model.MeasurementTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementTransactionRepository extends JpaRepository<MeasurementTransaction, Long> {
}
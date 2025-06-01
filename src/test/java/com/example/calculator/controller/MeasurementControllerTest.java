package com.example.calculator.controller;

import com.example.calculator.model.MeasurementTransaction;
import com.example.calculator.repository.MeasurementTransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MeasurementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MeasurementTransactionRepository repo;

    @Test
    @WithMockUser(username = "testuser")
    void testCircleArea() throws Exception {
        mockMvc.perform(get("/api/measure/calculate")
                .param("shape", "circle")
                .param("measureType", "area")
                .param("radius", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.shape").value("circle"))
                .andExpect(jsonPath("$.measureType").value("area"))
                .andExpect(jsonPath("$.value").value(Math.PI * 4));
        // Check DB entry
        assertThat(repo.findAll().stream().anyMatch(tx -> "circle".equals(tx.getShape()) && "area".equals(tx.getMeasureType()))).isTrue();
    }

    @Test
    @WithMockUser(username = "testuser")
    void testRectanglePerimeter() throws Exception {
        mockMvc.perform(get("/api/measure/calculate")
                .param("shape", "rectangle")
                .param("measureType", "perimeter")
                .param("length", "5")
                .param("width", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.shape").value("rectangle"))
                .andExpect(jsonPath("$.measureType").value("perimeter"))
                .andExpect(jsonPath("$.value").value(16.0));
    }

    @Test
    @WithMockUser(username = "testuser")
    void testCubeArea() throws Exception {
        mockMvc.perform(get("/api/measure/calculate")
                .param("shape", "cube")
                .param("measureType", "area")
                .param("side", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(24.0));
    }
}
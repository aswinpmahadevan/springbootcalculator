package com.example.calculator.controller;

import com.example.calculator.config.TestSecurityConfig;
import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
@Import(TestSecurityConfig.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    void testAdd() throws Exception {
        when(calculatorService.add(2.0, 3.0)).thenReturn(5.0);
        mockMvc.perform(get("/api/calc/add?a=2&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void testSubtract() throws Exception {
        when(calculatorService.subtract(5.0, 3.0)).thenReturn(2.0);
        mockMvc.perform(get("/api/calc/subtract?a=5&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    void testMultiply() throws Exception {
        when(calculatorService.multiply(2.0, 3.0)).thenReturn(6.0);
        mockMvc.perform(get("/api/calc/multiply?a=2&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("6.0"));
    }

    @Test
    void testDivide() throws Exception {
        when(calculatorService.divide(6.0, 3.0)).thenReturn(2.0);
        mockMvc.perform(get("/api/calc/divide?a=6&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    void testPower() throws Exception {
        when(calculatorService.power(2.0, 3.0)).thenReturn(8.0);
        mockMvc.perform(get("/api/calc/power?a=2&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("8.0"));
    }

    @Test
    void testRoot() throws Exception {
        when(calculatorService.root(27.0, 3.0)).thenReturn(3.0);
        mockMvc.perform(get("/api/calc/root?a=27&n=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0"));
    }

    @Test
    void testLog() throws Exception {
        when(calculatorService.log(8.0, 2.0)).thenReturn(3.0);
        mockMvc.perform(get("/api/calc/log?a=8&base=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0"));
    }

    @Test
    void testLn() throws Exception {
        when(calculatorService.ln(Math.E)).thenReturn(1.0);
        mockMvc.perform(get("/api/calc/ln?a=" + Math.E))
                .andExpect(status().isOk())
                .andExpect(content().string("1.0"));
    }

    @Test
    void testExp() throws Exception {
        when(calculatorService.exp(1.0)).thenReturn(Math.E);
        mockMvc.perform(get("/api/calc/exp?a=1"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(Math.E)));
    }

    @Test
    void testFactorial() throws Exception {
        when(calculatorService.factorial(5)).thenReturn(120L);
        mockMvc.perform(get("/api/calc/factorial?n=5"))
                .andExpect(status().isOk())
                .andExpect(content().string("120"));
    }

    @Test
    void testMod() throws Exception {
        when(calculatorService.mod(10.0, 3.0)).thenReturn(1.0);
        mockMvc.perform(get("/api/calc/mod?a=10&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("1.0"));
    }

    @Test
    void testAbs() throws Exception {
        when(calculatorService.abs(-5.0)).thenReturn(5.0);
        mockMvc.perform(get("/api/calc/abs?a=-5"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }
}
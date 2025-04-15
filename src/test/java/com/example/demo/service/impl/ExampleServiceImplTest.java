package com.example.demo.service.impl;

import com.example.demo.service.ExampleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ExampleServiceImplTest {

    private ExampleService exampleService;

    @BeforeEach
    void setUp() {
        exampleService = new ExampleServiceImpl();
    }

    @Test
    void sum() {
        int actualSum = exampleService.sum(2, 3);
        int expectedSum = 5;
        assertEquals(expectedSum, actualSum, "The expectation is not correct");
    }

    @Test
    void parity() {
        String actualParity = exampleService.parity(5);
        String expectedParity = "odd";
        assertEquals(expectedParity, actualParity);
    }
}
package com.example.demo.service.impl;

import com.example.demo.service.ExampleService;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public String parity(int a) {
        return a % 2 == 0 ? "even" : "odd";
    }
}

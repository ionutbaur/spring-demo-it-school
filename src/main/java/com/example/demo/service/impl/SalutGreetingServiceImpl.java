package com.example.demo.service.impl;

import com.example.demo.service.GreetingsService;
import org.springframework.stereotype.Service;

@Service
public class SalutGreetingServiceImpl implements GreetingsService {

    @Override
    public String getGreeting(String name) {
        return "Salut, " + name;
    }
}

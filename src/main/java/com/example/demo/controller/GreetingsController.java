package com.example.demo.controller;

import com.example.demo.service.GreetingsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    private final GreetingsService greetingsService;

    public GreetingsController(GreetingsService greetingsServiceImpl) {
        this.greetingsService = greetingsServiceImpl;
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return greetingsService.getGreeting(name);
    }
}

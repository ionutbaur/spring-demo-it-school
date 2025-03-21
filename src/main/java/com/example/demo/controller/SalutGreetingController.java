package com.example.demo.controller;

import com.example.demo.service.GreetingsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalutGreetingController {

    private final GreetingsService greetingsService;

    public SalutGreetingController(GreetingsService salutGreetingServiceImpl) {
        this.greetingsService = salutGreetingServiceImpl;
    }

    @GetMapping("/greet-salut/{name}")
    public String greet(@PathVariable String name) {
        return greetingsService.getGreeting(name);
    }
}

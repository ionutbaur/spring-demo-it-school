package com.example.demo.controller;

import com.example.demo.service.GreetingsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Greetings API", description = "This API just returns some greetings")
@RestController
public class GreetingsController {

    private final GreetingsService greetingsService;

    public GreetingsController(GreetingsService greetingsServiceImpl) {
        this.greetingsService = greetingsServiceImpl;
    }

    @Operation(summary = "Get a greeting", description = "Returns Hello concatenated with the name parameter")
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return greetingsService.getGreeting(name);
    }
}

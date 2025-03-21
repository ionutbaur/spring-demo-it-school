package com.example.demo.controller;

import com.example.demo.entity.Activity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ActivityController {

    @GetMapping("/activities")
    public Activity[] getActivities() {
        String url = "https://fakerestapi.azurewebsites.net/api/v1/Activities";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Activity[].class);
    }
}

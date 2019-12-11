package com.example.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Hello {

    @Value("${user.name}")
    private String name;

    @GetMapping("/hello")
    public String test(){
        return name;
    }
}

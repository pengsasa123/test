package com.example.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class Hello {

    @Value("${user.name}")
    private String name;

    @GetMapping("/hello")
    public String test(){
        log.info("#################进入了");
        return name;
    }
}

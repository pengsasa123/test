package com.example.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/test")
public class Hello {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.name}")
    private String name;

    @GetMapping("/hello")
    public String test(){
        log.info("#################进入了");
        return name;
    }


    @GetMapping("/test")
    public String test2(){
        String forObject = restTemplate.getForObject("http://qingzu/test/hello", String.class);
        return forObject;
    }
}

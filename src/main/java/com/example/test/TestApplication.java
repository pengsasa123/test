package com.example.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class TestApplication {

    public static void main(String[] args) {
        log.info("------------start------------");
        SpringApplication.run(TestApplication.class, args);
        log.info("------------end------------");
    }

}

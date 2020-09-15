package com.matcha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Springboot2HellowordApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2HellowordApplication.class, args);
    }

    @GetMapping("/test")
    public Object test() {
        return "hello word";
    }
}

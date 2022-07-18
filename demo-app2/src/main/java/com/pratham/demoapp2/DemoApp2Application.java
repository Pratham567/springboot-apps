package com.pratham.demoapp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class DemoApp2Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoApp2Application.class, args);
    }

    @GetMapping("/")
    public String greet() {
        return "Greetings from demo2 app";
    }
}

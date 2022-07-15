package com.pratham.demofeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients("com.pratham.demofeignclient.feignclients")
@RestController
public class DemoFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoFeignClientApplication.class, args);
    }

    @GetMapping("/")
    public String greet() {
        return "Greetings from demofeignclient app";
    }

}

package com.pratham.demoapp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class DemoApp2Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoApp2Application.class, args);
    }

    @Bean("restTemplate")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean("loadBalancedRestTemplate")
    @LoadBalanced
    public RestTemplate getLoadBalancedRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/")
    public String greet() {
        return "Greetings from demo2 app";
    }
}

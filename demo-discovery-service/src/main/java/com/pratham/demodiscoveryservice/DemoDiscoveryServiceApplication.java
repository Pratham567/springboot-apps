package com.pratham.demodiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoDiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDiscoveryServiceApplication.class, args);
    }

}

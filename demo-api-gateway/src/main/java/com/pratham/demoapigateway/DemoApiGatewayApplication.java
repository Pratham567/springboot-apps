package com.pratham.demoapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApiGatewayApplication {

    public static void main(String[] args) {
        /**
         * Use this to prevent the automatic restart on builds, if using dev tools
         * System.setProperty("spring.devtools.restart.enabled", "false");
         */
        SpringApplication.run(DemoApiGatewayApplication.class, args);
    }

}

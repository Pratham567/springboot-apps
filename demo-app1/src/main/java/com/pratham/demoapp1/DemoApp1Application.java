package com.pratham.demoapp1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApp1Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoApp1Application.class, args);
    }

    @Value("${app.instance.id:0}")
    private String instanceId;

    // @Bean
    // public String getInstanceId(){return instanceId;}

    @GetMapping("/")
    public String greet() {
        return "Greetings from demo1 app. InstanceId: " + instanceId;
    }

}

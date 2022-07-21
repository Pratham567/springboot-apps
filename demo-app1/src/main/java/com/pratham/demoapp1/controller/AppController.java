package com.pratham.demoapp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo1")
public class AppController {

    @Value("${app.instance.id:0}")
    private String instanceId;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Invoked demo1 hello api. InstanceId: " + instanceId);
        return "Hello from app: 1. InstanceId: " + instanceId;
    }

    @GetMapping("/bye")
    public String bye() {
        return "Bye from app: 1. InstanceId: " + instanceId;
    }

}

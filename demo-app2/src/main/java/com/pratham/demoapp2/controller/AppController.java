package com.pratham.demoapp2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo2")
public class AppController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from app: 2 ";
    }

    @GetMapping("/bye")
    public String bye() {
        return "Hello from app: 2 ";
    }

}


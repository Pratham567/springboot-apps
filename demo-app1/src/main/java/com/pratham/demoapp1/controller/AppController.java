package com.pratham.demoapp1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo1")
public class AppController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Invoked demo1 hello api");
        return "Hello from app: 1";
    }

    @GetMapping("/bye")
    public String bye() {
        return "Bye from app: 1";
    }

}

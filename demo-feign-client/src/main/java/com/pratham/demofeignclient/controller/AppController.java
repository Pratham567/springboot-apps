package com.pratham.demofeignclient.controller;

import com.pratham.demofeignclient.feignclients.DemoOneFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/feignclient/demo1")
public class AppController {

    @Autowired
    private DemoOneFeignClient demo1FeignClient;

    @GetMapping("/hello")
    public String hello(){
        return demo1FeignClient.hello() + "via FeignClientDemo1";
    }

    @GetMapping("/bye")
    public String bye(){
        return demo1FeignClient.bye() + "via FeignClientDemo1";
    }

}

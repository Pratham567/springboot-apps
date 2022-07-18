package com.pratham.demofeignclient.controller;

import com.pratham.demofeignclient.feignclients.DemoOneFeignClient;
import com.pratham.demofeignclient.feignclients.DemoTwoFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/feignclient")
public class AppController {

    @Autowired
    private DemoOneFeignClient demo1FeignClient;
    @Autowired
    private DemoTwoFeignClient demo2FeignClient;

    @GetMapping
    public String baseApi() {
        return "Hello from base API /api/v1/feignclient without eureka. You may want to invoke the following: /APP/[hello/bye]";
    }

    @GetMapping("/demo1/hello")
    public String hello1() {
        return demo1FeignClient.hello() + "via FeignClientDemo1 without Eureka";
    }

    @GetMapping("/demo1/bye")
    public String bye1() {
        return demo1FeignClient.bye() + "via FeignClientDemo1 without Eureka";
    }

    @GetMapping("/demo2/hello")
    public String hello2() {
        return demo2FeignClient.hello() + "via FeignClientDemo2 without Eureka";
    }

    @GetMapping("/demo2/bye")
    public String bye2() {
        return demo2FeignClient.bye() + "via FeignClientDemo2 without Eureka";
    }

}

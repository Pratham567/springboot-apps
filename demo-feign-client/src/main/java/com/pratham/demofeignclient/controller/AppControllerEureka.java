package com.pratham.demofeignclient.controller;

import com.pratham.demofeignclient.feignclients.DemoOneFeignClientEureka;
import com.pratham.demofeignclient.feignclients.DemoTwoFeignClientEureka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/feignclient/eureka")
public class AppControllerEureka {

    private final DemoOneFeignClientEureka demo1FeignClient;
    private final DemoTwoFeignClientEureka demo2FeignClient;

    public AppControllerEureka(DemoOneFeignClientEureka demo1FeignClient, DemoTwoFeignClientEureka demo2FeignClient) {
        this.demo1FeignClient = demo1FeignClient;
        this.demo2FeignClient = demo2FeignClient;
    }

    @GetMapping
    public String baseApi() {
        return "Hello from base API /api/v1/feignclient/eureka. You may want to invoke the following: /APP/[hello/bye]";
    }

    @GetMapping("/demo1/hello")
    public String hello1() {
        return demo1FeignClient.hello() + " via Eureka via FeignClientDemo1";
    }

    @GetMapping("/demo1/bye")
    public String bye1() {
        return demo1FeignClient.bye() + " via Eureka via FeignClientDemo1";
    }

    @GetMapping("/demo2/hello")
    public String hello2() {
        return demo2FeignClient.hello() + " via Eureka via FeignClientDemo2";
    }

    @GetMapping("/demo2/bye")
    public String bye2() {
        return demo2FeignClient.bye() + " via Eureka via FeignClientDemo2";
    }

}

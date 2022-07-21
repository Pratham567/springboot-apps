package com.pratham.demofeignclient.controller;

import com.pratham.demofeignclient.feignclients.DemoFeignClientEurekaApiGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/feignclient/eureka/api-gateway")
public class AppControllerEurekaApiGateway {

    private final DemoFeignClientEurekaApiGateway demoFeignClientEurekaApiGateway;

    public AppControllerEurekaApiGateway(DemoFeignClientEurekaApiGateway demoFeignClientEurekaApiGateway) {
        this.demoFeignClientEurekaApiGateway = demoFeignClientEurekaApiGateway;
    }

    @GetMapping
    public String baseApi() {
        return "Hello from base API /api/v1/feignclient/eureka/api-gateway. This feign call will make request to APP via api-gateway. You may want to invoke the following: /APP/[hello/bye]";
    }

    @GetMapping("/demo1/hello")
    public String hello1() {
        return demoFeignClientEurekaApiGateway.hello1() + " via api-gateway via Eureka via FeignClientDemo1";
    }

    @GetMapping("/demo1/bye")
    public String bye1() {
        return demoFeignClientEurekaApiGateway.bye1() + " via api-gateway via Eureka via FeignClientDemo1";
    }

    @GetMapping("/demo2/hello")
    public String hello2() {
        return demoFeignClientEurekaApiGateway.hello2() + " via api-gateway via Eureka via FeignClientDemo1";
    }

    @GetMapping("/demo2/bye")
    public String bye2() {
        return demoFeignClientEurekaApiGateway.bye2() + " via api-gateway via Eureka via FeignClientDemo1";
    }

}

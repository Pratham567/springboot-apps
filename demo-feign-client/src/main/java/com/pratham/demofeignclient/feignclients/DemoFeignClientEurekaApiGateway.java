package com.pratham.demofeignclient.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "demo-api-gateway") // value == name (of feign-client)
public interface DemoFeignClientEurekaApiGateway {

    @GetMapping("/demo-app1/api/v1/demo1/hello")
    String hello1();

    @GetMapping("/demo-app1/api/v1/demo1/bye")
    String bye1();

    @GetMapping("/demo-app2/api/v1/demo2/hello")
    String hello2();

    @GetMapping("/demo-app2/api/v1/demo2/bye")
    String bye2();

}

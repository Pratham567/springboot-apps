package com.pratham.demofeignclient.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "demo-app2", path = "/api/v1/demo2")
public interface DemoTwoFeignClientEureka {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/bye")
    String bye();

}

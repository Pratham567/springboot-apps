package com.pratham.demofeignclient.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "demo-app1", path = "/api/v1/demo1")
public interface DemoOneFeignClientEureka {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/bye")
    String bye();

}

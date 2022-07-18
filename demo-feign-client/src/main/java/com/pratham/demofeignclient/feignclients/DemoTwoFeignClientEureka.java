package com.pratham.demofeignclient.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "demo-app2")
public interface DemoTwoFeignClientEureka {

    @GetMapping("/api/v1/demo2/hello")
    String hello();

    @GetMapping("/bye")
    String bye();

}

package com.pratham.demofeignclient.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "${app.demo2.url}", value = "demo2-feign-client", path = "/api/v1/demo2")
public interface DemoTwoFeignClient {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/bye")
    String bye();

}

package com.pratham.demofeignclient.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "${app.demo1.url}", value = "demo1-feign-client", path = "/api/v1/demo1")
public interface DemoOneFeignClient {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/bye")
    String bye();

}

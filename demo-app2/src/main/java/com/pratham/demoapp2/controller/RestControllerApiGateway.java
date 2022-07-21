package com.pratham.demoapp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/demo1/rest-template/api-gateway")
public class RestControllerApiGateway {

    private final RestTemplate restTemplate;

    @Autowired
    private final RestTemplate loadBalancedRestTemplate;

    public RestControllerApiGateway(RestTemplate restTemplate, RestTemplate loadBalancedRestTemplate) {
        this.restTemplate = restTemplate;
        this.loadBalancedRestTemplate = loadBalancedRestTemplate;
    }

    @GetMapping("/demo1/hello")
    public String demo1Hello() {

        // This will work as well, but need to provide the exact location of api-gateway
        return restTemplate.getForObject("http://localhost:9001/demo-app1/api/v1/demo1/hello", String.class) + " via restTemplate via api-gateway from demo-app2";

        // The following fails with unknown host exception unless we provide a LoadBalanced resttemplate
        // return loadBalancedRestTemplate.getForObject("http://demo-api-gateway/demo-app1/api/v1/demo1/hello", String.class) + " via Load Balanced restTemplate via api-gateway from demo-app2";
    }



}

package com.pratham.demoappreactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient.Builder;

@RestController
@RequestMapping("/api/v1/demo-reactive/api-gateway")
public class AppControllerApiGateway {

    private final Builder webClientBuilder;

    public AppControllerApiGateway(Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping("/call/demo1/hello")
    public String hello() {
        return webClientBuilder.build().get().uri("http://localhost:9001/demo-app1/api/v1/demo1/hello").retrieve()
                .bodyToMono(String.class).block() + " via a blocking reactive client with api-gateway";
    }

    @GetMapping("/call/demo1/bye")
    public String bye() {
        return webClientBuilder.build().get().uri("http://localhost:9001/api/v1/demo1/bye").retrieve()
                .bodyToMono(String.class).block() + " via a blocking reactive client with api-gateway";
    }

    @GetMapping
    public String baseApiUrl() {
        return "Hi, this is the /api/v1/demo-reactive with api-gateway. You may want to use /call/demo1/[hello/bye]";
    }
}

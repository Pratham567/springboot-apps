package com.pratham.demofeignclient.controller;

import com.pratham.demofeignclient.feignclients.DemoFeignClientEurekaApiGateway;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/feignclient/eureka/api-gateway")
public class AppControllerEurekaApiGateway {

    private final DemoFeignClientEurekaApiGateway demoFeignClientEurekaApiGateway;
    Logger logger = LoggerFactory.getLogger(AppControllerEurekaApiGateway.class);
    long count = 1;
    long circuitBreakerFallbackCount = 1;
    long retryFallbackCount = 1;

    public AppControllerEurekaApiGateway(DemoFeignClientEurekaApiGateway demoFeignClientEurekaApiGateway) {
        this.demoFeignClientEurekaApiGateway = demoFeignClientEurekaApiGateway;
        logger.info("instanciating AppControllerEurekaApiGateway class");
    }

    @GetMapping
    public String baseApi() {
        return "Hello from base API /api/v1/feignclient/eureka/api-gateway. This feign call will make request to APP via api-gateway. You may want to invoke the following: /APP/[hello/bye]";
    }

    // Retry overlaps the circuitbreaker and is executed later,
    // so if fallback is present in the circuitbreaker anotation,
    // then that will be executed and the call would never come to retry.
    @GetMapping("/demo1/hello")
    @Retry(name = "demo-retry-config", fallbackMethod = "retryFallbackDemo1Hello")
    @CircuitBreaker(name = "demo-circuitbreaker-config")
    // @CircuitBreaker(name = "demo-circuitbreaker-config", fallbackMethod = "fallbackDemo1Hello")
    public String hello1() {
        logger.info("Count: " + count++);
        return demoFeignClientEurekaApiGateway.hello1() + " via api-gateway via Eureka via FeignClientDemo1";
    }

    private String fallbackDemo1Hello(Throwable th) {
        logger.info("Inside the circuitbreaker fallbackDemo1Hello function!!");
        logger.info("Retry Fallback count: " + retryFallbackCount++);
        // logger.error("Error: ", th);
        return "You have got a fallback response from circuitbreaker fallbackDemo1Hello";
    }

    private String retryFallbackDemo1Hello(Throwable th) {
        logger.info("Inside the retry fallbackDemo1Hello function!!");
        logger.info("Circuitbreaker Fallback count: " + circuitBreakerFallbackCount++);
        // logger.error("Error: ", th);
        return "You have got a fallback response from retry fallbackDemo1Hello";
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

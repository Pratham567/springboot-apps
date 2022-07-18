// package com.pratham.demofeignclient.config;
//
// import feign.Feign;
// import org.springframework.cloud.client.loadbalancer.LoadBalanced;
// import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
// import org.springframework.context.annotation.Bean;
//
// @LoadBalancerClient(value = "demo1")
// public class DemoOneLoadBalConfig {
//
//     @LoadBalanced
//     @Bean
//     public Feign.Builder feignBuilder(){
//         return Feign.builder();
//     }
//
// }

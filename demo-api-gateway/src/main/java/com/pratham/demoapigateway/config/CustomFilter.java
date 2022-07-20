package com.pratham.demoapigateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class CustomFilter implements GlobalFilter {

    Logger logger = LoggerFactory.getLogger(CustomFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("This log comes from a pre-filter: ");
        ServerHttpRequest request = exchange.getRequest();
        logger.info(" Request URI: " + request.getURI().toString());
        logger.info("Authorization: " + request.getHeaders().getFirst("Authorization"));

        // NOTE: the URI doesn't contain the instance ID, it is automatically trimmed off earlier by the api gateway

        // // API specific changes, can have if...else on the uri
        if(request.getURI().toString().contains("/api/v1/demo1")){
            // do something
            logger.info("This request goes to app: demo1");
        }

        // // Return without modifying any post filters
        // return chain.filter(exchange);

        // // Set Post filters
        return  chain.filter(exchange).then(Mono.fromRunnable(() -> {

            // // Note: we can have uri specific filters here as well!

            ServerHttpResponse response = exchange.getResponse();
            logger.info("This log comes from post filter. Status: " + response.getStatusCode());
        }));
    }
}

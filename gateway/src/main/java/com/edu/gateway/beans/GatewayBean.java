package com.edu.gateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GatewayBean {

    @Bean
    @Profile("eureka-off")
    public RouteLocator routeLocatorEurekaOff(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(route -> route
                        .path("/companies-crud/api/v1/companies/**")
                        .uri("http://localhost:8082"))
                .route(route -> route
                        .path("/report-ms/api/v1/companies/**")
                        .uri("http://localhost:7070"))
                .build();
    }

    @Bean
    @Profile("eureka-on")
    public RouteLocator routeLocatorEurekaOn(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(route -> route
                        .path("/companies-crud/api/v1/companies/**")
                        .uri("lb://companies-crud"))
                .route(route -> route
                        .path("/report-ms/api/v1/companies/**")
                        .uri("lb://report-ms"))
                .build();
    }
}

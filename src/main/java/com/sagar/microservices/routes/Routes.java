package com.sagar.microservices.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.*;


@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return GatewayRouterFunctions.route("product_service")
                .route(RequestPredicates.path("api/product"), HandlerFunctions.http("http://localhost:8080/"))
                .build();
    }
}

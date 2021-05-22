package com.example.asynchronous

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class AsynchronousConfig {

    @Bean
    fun route(controller: Controller): RouterFunction<ServerResponse> {
        return RouterFunctions
            .route(
                RequestPredicates.GET("/io-bound"), controller::ioBound
            )
            .andRoute(
                RequestPredicates.GET("/cpu-bound"), controller::cpuBound
            )
    }
}
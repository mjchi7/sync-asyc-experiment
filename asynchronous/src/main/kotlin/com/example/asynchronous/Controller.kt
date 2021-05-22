package com.example.asynchronous

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.math.BigInteger
import java.time.Duration
import java.util.concurrent.Executors

@Component
class Controller {

    fun ioBound(request: ServerRequest) : Mono<ServerResponse> {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue("ok")).delayElement(Duration.ofSeconds(5))
    }

    fun cpuBound(request: ServerRequest) : Mono<ServerResponse> {
        val executors = Executors.newFixedThreadPool(5)
        for (thread in 1..5) {
            executors.submit {
                for (i in 1L..30L) {
                    println("Calculating fibonacci for $i")
                    fib(BigInteger.valueOf(i))
                }
            }
            /* Coroutines
            runBlocking {
                launch {
                    for (i in 1L..30L) {
                        println("Calculating fibonacci for $i")
                        fib(BigInteger.valueOf(i))
                    }
                }
            }
            */
        }
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue("ok"))
    }

    private fun fib(n: BigInteger): BigInteger {
        return if (n.compareTo(BigInteger.ONE) == -1 || n.compareTo(BigInteger.ONE) == 0) n;
        else
            fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.ONE)).subtract(BigInteger.ONE))
    }
}
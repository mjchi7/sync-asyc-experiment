package com.example.synchronous

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SynchronousApplication

fun main(args: Array<String>) {
	runApplication<SynchronousApplication>(*args)
}

package com.kotlin.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
    // Spring version 2.0.2 에서 사용가능
    /*runApplication<Application>(*args){
        setBannerMode(Banner.Mode.OFF)
    }*/
}
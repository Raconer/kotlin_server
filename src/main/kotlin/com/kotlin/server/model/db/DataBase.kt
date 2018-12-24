package com.kotlin.server.model.db

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "jdbc.default")
class DataBase{
    lateinit var url:String
    lateinit var driver:String
    lateinit var username:String
    lateinit var password:String

    override fun toString(): String {
        return "{ url : $url, \n" +
                " dirver : $driver, \n" +
                " id : $username, \n" +
                " password : $password }"
    }
}
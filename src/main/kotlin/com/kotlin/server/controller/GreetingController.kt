package com.kotlin.server.controller

import com.kotlin.server.database.NoticeMapper
import com.kotlin.server.model.Greeting
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController{

    @Autowired
    lateinit var noticeData:NoticeMapper

    val counter = AtomicLong()

    @GetMapping("/")
    fun main(model: Model):String{
        model.addAttribute("mainData", "Send Main Test Data")
        //model[""] = "test"
        return "main"
    }

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        val cnt = noticeData.getNoticeCnt()
        return Greeting(counter.incrementAndGet(), "Hello, $name $cnt")
    }
}
package com.kotlin.server.controller

import com.kotlin.server.database.NoticeMapper
import com.kotlin.server.model.Greeting
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.concurrent.atomic.AtomicLong
import javax.servlet.http.HttpServletRequest

@Controller
class GreetingController{

    @Autowired
    lateinit var noticeData:NoticeMapper

    val counter = AtomicLong()

    @GetMapping("/")
    fun main(model: Model, request:HttpServletRequest):String{
        model.addAttribute("mainData", "Send Main Test Data")
        //model[""] = "test" // spring 2.0.2.RELEASE 에서 사용가능
        //model["title"] = "Blog"
        System.out.println(request.requestURI)
        System.out.println(request.requestURL)

        return "main"
    }

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        val cnt = noticeData.getNoticeCnt()
        return Greeting(counter.incrementAndGet(), "Hello, $name $cnt")
    }
}
package com.kotlin.server.database

import com.kotlin.server.model.db.DataBase
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class NoticeMapper{

    @Autowired
    lateinit var data:DataBase

    fun getNoticeCnt():Int{
        Database.connect(data.url, data.driver, data.username, data.password)
        var result = 0
        transaction {
            addLogger(StdOutSqlLogger)
            result = com.kotlin.server.controller.GreetingController.Notice.selectAll().count()
        }
        return result
    }


}
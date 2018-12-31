package com.kotlin.server.database

import com.kotlin.server.model.db.DataBase
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class NoticeMapper{

    @Autowired
    lateinit var data:DataBase

    object Notice : Table()

    fun getNoticeCnt():Int{
        Database.connect(data.url, data.driver, data.username, data.password)
        var result = 0
        transaction {
            addLogger(StdOutSqlLogger)
            result = Notice.selectAll().count()
        }
        return result
    }


}
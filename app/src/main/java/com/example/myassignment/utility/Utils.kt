package com.example.myassignment.utility

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object Utils {

    @JvmStatic
    fun parseMilliseconds(millis: Long): String {
        // New date object from millis
        val date = Date(millis)
// formattter
        val formatter = SimpleDateFormat("HH:mm:ss")
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"))
// Pass date object
        val formatted = formatter.format(date)

        return formatted
    }
}
package com.example.myassignment.utility

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object Utils {

    @JvmStatic
    fun parseMilliseconds(millis: Long): String {
        // New date object from millis
        var date = Date(millis)
// formattter
        var formatter = SimpleDateFormat("HH:mm:ss")
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"))
// Pass date object
        var formatted = formatter.format(date)

        return formatted
    }
}
package com.yojan.learning.util

import java.text.SimpleDateFormat
import java.util.Calendar.getInstance
import java.util.Date
import java.util.Locale

fun Date.getCurrentTimeStamp(): String {
    val calendar = getInstance(Locale.US)
    val myLocale = Locale("en", "US")
    val format = SimpleDateFormat("dd/MM/y HH:mm:ss", myLocale)
    return format.format(calendar.time)
}
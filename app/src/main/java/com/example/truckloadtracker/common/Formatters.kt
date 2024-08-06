package com.example.truckloadtracker.common

import java.time.format.DateTimeFormatter

object Formatters {
    val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("EEE, MMM d")
    val timeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")
}

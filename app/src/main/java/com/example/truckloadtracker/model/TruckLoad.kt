package com.example.truckloadtracker.model

import java.time.ZonedDateTime

data class TruckLoad(
    val originLocation: String = "",
    val destinationLocation: String = "",
    val pickupDateTime: ZonedDateTime = ZonedDateTime.now(),
    val deliveryDateTime: ZonedDateTime = ZonedDateTime.now(),
    val brokerName: String = "",
    val weight: Int = 0,
    val rate: Float = 0f
)

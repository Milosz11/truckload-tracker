package com.example.truckloadtracker.model

data class TruckLoad(
    val originLocation: String = "",
    val destinationLocation: String = "",
    val pickupDateTime: String = "",
    val deliveryDateTime: String = "",
    val brokerName: String = "",
    val weight: Int = 0,
    val rate: Float = 0f
)
